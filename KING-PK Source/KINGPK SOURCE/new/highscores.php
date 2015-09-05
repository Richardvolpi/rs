<?php

define('PUN_ROOT', './');
require PUN_ROOT.'include/common.php';

$xml = isset($_GET['display']) && trim($_GET['display']) == 'xml';

if ($pun_user['g_read_board'] == '0' && !$xml)
	guest_page();

// Load the userlist.php language file
require PUN_ROOT.'lang/'.$pun_user['language'].'/userlist.php';

// Load the search.php language file
require PUN_ROOT.'lang/'.$pun_user['language'].'/search.php';

$skill = isset($_GET['skill']) ? strtolower(pun_trim($_GET['skill'])) : 'combat';
$username = isset($_GET['username']) ? pun_trim($_GET['username']) : '';
$show_group = (!isset($_GET['show_group']) || intval($_GET['show_group']) < -1 && intval($_GET['show_group']) > 2) ? -1 : intval($_GET['show_group']);
$sort_by = (!isset($_GET['sort_by']) || $_GET['sort_by'] != 'username' && $_GET['sort_by'] != 'owner' && $_GET['sort_by'] != $skill && $_GET['sort_by'] != 'skill_total' && $_GET['sort_by'] != 'creation_date') ? (isset($_GET['skill']) ? 'skl_'.$skill : 'skill_total') : trim($_GET['sort_by']);
$sort_dir = (!isset($_GET['sort_dir']) || $_GET['sort_dir'] != 'ASC' && $_GET['sort_dir'] != 'DESC') ? 'DESC' : strtoupper($_GET['sort_dir']);
$country = isset($_GET['country']) ? pun_trim($_GET['country']) : false;
$char = isset($_GET['sort_char']) ? trim($_GET['sort_char']) : false;
$sort_friends = isset($_GET['sort_friends']);
$sort_kills = isset($_GET['sort_kills']);

if($char) {
	$result = $db->query('SELECT 1 FROM '.$db->prefix.'rscd_players WHERE user='.$db->escape($char).' AND owner='.$pun_user['id']) or error('Unable to check characters owner', __FILE__, __LINE__, $db->error());
	if(!$db->num_rows($result)) {
		message('Invalid character (or maybe not yours!)');
	}
}

function extract_value($user) {
	global $skill;
	if($skill == 'combat')
		return $user['combat'];
	else if($skill == 'kills')
		return $user['kills'];
	return experience_to_level($user['exp_'.$skill]);
}

function extract_exp($user) {
	global $skill;
	if($skill == 'combat' || $skill == 'kills')
		return false;
	return $user['exp_'.$skill];
}

if($xml) {
	if(substr($sort_by, 0, 4) == 'skl_') {
		if($sort_by == 'skl_combat') {
			$table = 'Combat';
			$sort = 'r.combat';
		}
		else if($sort_by == 'skl_kills') {
			$table = 'Unique Kills';
			$sort = 'kills';
		}
		else {
			$sort = substr($sort_by, 4);
			if(!in_array($sort, $skills) || in_array($sort, $blocked)) {
				echo 'Invalid skill'."\n";
				$db->close();
				exit;
			}
			
			$table = ucwords($sort);
			$sort = 'e.exp_'.$db->escape($sort);
		}
	}
	else {
		$table = ucwords(str_replace('_', ' ', $sort_by));
		$sort = 'r.'.$sort_by;
	}
	
	header('Content-type: text/xml; charset: UTF-8');
	echo '<?xml version="1.0" encoding="utf-8"?>'."\n";
?>
<!-- Top 10 for: <?php echo pun_htmlspecialchars($table); ?> -->
<highscores>
<?php

	// Grab the users
	$result = $db->query('SELECT r.*, e.*, COUNT(DISTINCT k.killed) AS kills FROM '.$db->prefix.'rscd_players AS r INNER JOIN '.$db->prefix.'rscd_experience AS e ON e.user=r.user LEFT JOIN '.$db->prefix.'rscd_kills AS k ON k.user=r.user AND k.type=1 LEFT JOIN '.$db->prefix.'users AS u ON u.id=r.owner WHERE u.group_id!='.PUN_ADMIN.' GROUP BY r.user ORDER BY '.$sort.' DESC, r.creation_date ASC LIMIT 0, 10') or error('Unable to fetch account list', __FILE__, __LINE__, $db->error());
	while($user = $db->fetch_assoc($result)) {
?>
	<player>
		<id><?php echo pun_htmlspecialchars($user['user']); ?></id>
		<username><?php echo pun_htmlspecialchars($user['username']); ?></username>
		<?php echo '<'.pun_htmlspecialchars($skill).'>'.extract_value($user).'</'.pun_htmlspecialchars($skill).'>'."\n"; ?>
<?php

		$exp = extract_exp($user);
		if($exp !== false) {
			echo "\t\t".'<'.pun_htmlspecialchars($skill).'_experience>'.$exp.'</'.pun_htmlspecialchars($skill).'_experience>'."\n";
		}

?>
		<skillTotal><?php echo pun_htmlspecialchars($user['skill_total']); ?></skillTotal>
		<registered><?php echo intval($user['creation_date']); ?></registered>
	</player>
<?php
	}
?>
</highscores>
<?php
	$db->close();
	exit;
}

$page_title = pun_htmlspecialchars($pun_config['o_board_title']).' / Highscores';
$focus_element = array('highscore', 'username');

define('PUN_ALLOW_INDEX', 1);
require PUN_ROOT.'header.php';

?>
<div class="blockform">
	<h2><span>Player Search</span></h2>
	<div class="box">
	<form id="highscore" method="get" action="highscores.php">
		<div class="inform">
			<input type="hidden" name="skill" value="<?php echo pun_htmlspecialchars($skill); ?>" />
			<fieldset>
				<legend>Choose a skill to browse</legend>
				<div class="infldset">
	    				<table cellspacing="0" class="invisible">
	    					<tr>
	    						<td><?php echo '<a href="highscores.php?skill=combat'.($country ? '&amp;country='.$country : '').($char ? '&amp;sort_char='.$char : '').($sort_friends ? '&amp;sort_friends=1' : '').($sort_kills ? '&amp;sort_kills=1' : '').'"><img src="img/skills/combat.png" alt="" />&nbsp;Combat</a>'; ?></td>
	    						<td><?php echo '<a href="highscores.php?skill=kills'.($country ? '&amp;country='.$country : '').($char ? '&amp;sort_char='.$char : '').($sort_friends ? '&amp;sort_friends=1' : '').($sort_kills ? '&amp;sort_kills=1' : '').'"><img src="img/skills/kills.png" alt="" />&nbsp;Kills</a>'; ?></td>
<?php for($i = $x = 0;$i < count($skills);$i++) {
	if(in_array($skills[$i], $blocked)) {
		continue;
	}
	
	echo "\t\t\t\t\t\t\t".'<td><a href="highscores.php?skill='.pun_htmlspecialchars($skills[$i]).($country ? '&amp;country='.$country : '').($char ? '&amp;sort_char='.$char : '').($sort_friends ? '&amp;sort_friends=1' : '').($sort_kills ? '&amp;sort_kills=1' : '').'"><img src="img/skills/'.pun_htmlspecialchars($skills[$i]).'.png" alt="" />&nbsp;'.pun_htmlspecialchars(ucwords($skills[$i])).'</a></td>'."\n";
	if(++$x % 8 == 6) {
		echo "\t\t\t\t\t\t".'</tr>'."\n";
		echo "\t\t\t\t\t\t".'<tr>'."\n";
	}
} ?>
	    					</tr>
	    				</table>
				</div>
			</fieldset>
			<br />
			<fieldset>
				<legend><?php echo $lang_ul['User find legend'] ?></legend>
				<div class="infldset">
<?php if ($pun_user['g_search_users'] == '1'): ?>					<label class="conl"><?php echo $lang_common['Username'] ?><br /><input type="text" name="username" value="<?php echo pun_htmlspecialchars($username) ?>" size="25" maxlength="25" /><br /></label>
<?php endif; ?>					<label class="conl"><?php echo $lang_ul['User group']."\n" ?>
					<br /><select name="show_group">
						<option value="-1"<?php if ($show_group == -1) echo ' selected="selected"' ?>><?php echo $lang_ul['All users'] ?></option>
<?php

$result = $db->query('SELECT g_id, g_title FROM '.$db->prefix.'groups WHERE g_id!='.PUN_GUEST.' ORDER BY g_id') or error('Unable to fetch user group list', __FILE__, __LINE__, $db->error());

while ($cur_group = $db->fetch_assoc($result))
{
	if ($cur_group['g_id'] == $show_group)
		echo "\t\t\t\t\t\t".'<option value="'.$cur_group['g_id'].'" selected="selected">'.pun_htmlspecialchars($cur_group['g_title']).'</option>'."\n";
	else
		echo "\t\t\t\t\t\t".'<option value="'.$cur_group['g_id'].'">'.pun_htmlspecialchars($cur_group['g_title']).'</option>'."\n";
}

?>
					</select>
					<br /></label>
					<label class="conl"><?php echo $lang_search['Sort by']."\n" ?>
					<br />
					<select name="sort_by">
						<option value="username"<?php if ($sort_by == 'username') echo ' selected="selected"' ?>>Username</option>
						<option value="owner"<?php if ($sort_by == 'owner') echo ' selected="selected"' ?>>Owner</option>
						<option value="skl_<?php echo pun_htmlspecialchars($skill); ?>"<?php if ($sort_by == 'skl_'.$skill) echo ' selected="selected"' ?>><?php echo pun_htmlspecialchars(ucwords($skill)); ?></option>
						<option value="skill_total"<?php if ($sort_by == 'skill_total') echo ' selected="selected"' ?>>Skill Total</option>
						<option value="creation_date"<?php if ($sort_by == 'creation_date') echo ' selected="selected"' ?>>Registered</option>
					</select>
					<br /></label>
					<label class="conl"><?php echo $lang_search['Sort order']."\n" ?>
					<br /><select name="sort_dir">
						<option value="ASC"<?php if ($sort_dir == 'ASC') echo ' selected="selected"' ?>><?php echo $lang_search['Ascending'] ?></option>
						<option value="DESC"<?php if ($sort_dir == 'DESC') echo ' selected="selected"' ?>><?php echo $lang_search['Descending'] ?></option>
					</select>
					<br /></label>
					<p class="clearb">Enter a username to search for and/or a user group to filter by. The username field can be left blank. Use the wildcard character * for partial matches. Sort players by username, owner, combat, skill total or date registered and in ascending/descending order.</p>
				</div>
			</fieldset>
			<br />
			<fieldset>
				<legend>Filter Personal Highscores</legend>
				<div class="infldset">
					<label class="conl">For character
					<br /><select name="sort_char">
<?php

$result = $db->query('SELECT user, username FROM '.$db->prefix.'rscd_players WHERE owner='.$pun_user['id']) or error('Unable to fetch character list', __FILE__, __LINE__, $db->error());
while ($cur_char = $db->fetch_assoc($result)) {
	echo "\t\t\t\t\t\t".'<option value="'.$cur_char['user'].'"'.($char == $cur_char['user'] ? ' selected="selected"' : '').'>'.pun_htmlspecialchars($cur_char['username']).'</option>'."\n";
}

?>
					</select>
					<br /></label>
					<label class="conl">Friends
					<br /><input type="checkbox" name="sort_friends" value="1"<?php echo $sort_friends ? ' checked="checked"' : ''; ?> />
					<br /></label>
					<label class="conl">Kills
					<br /><input type="checkbox" name="sort_kills" value="1"<?php echo $sort_kills ? ' checked="checked"' : ''; ?> />
					<br /></label>
					<p class="clearb">Filter highscores by personal options such as friend list or kills.</p>
				</div>
			</fieldset>
		</div>
		<p><input type="submit" name="search" value="<?php echo $lang_common['Submit'] ?>" accesskey="s" /></p>
	</form>
	</div>
</div>
<?php

if(substr($sort_by, 0, 4) == 'skl_') {
	if($sort_by == 'skl_combat')
		$sort = 'r.combat';
	else if($sort_by == 'skl_kills')
		$sort = 'kills';
	else {
		$sort = substr($sort_by, 4);
		if(!in_array($sort, $skills) || in_array($sort, $blocked)) {
?>
<div id="users1" class="blocktable">
	<h2><span>Error</span></h2>
	<div class="box">
		<div class="inbox">
			<p style="margin:4px">Invalid skill</p>
		</div>
	</div>
</div>
<?php
			include PUN_ROOT.'footer.php';
			exit;
		}
		$sort = 'e.exp_'.$db->escape($sort);
	}
}
else {
	$sort = 'r.'.$sort_by;
}


// Create any SQL for the WHERE clause
$where_sql = array();
$like_command = ($db_type == 'pgsql') ? 'ILIKE' : 'LIKE';

if ($pun_user['g_search_users'] == '1' && $username != '')
	$where_sql[] = 'r.username '.$like_command.' \''.$db->escape(str_replace('*', '%', $username)).'\'';
if ($show_group > -1)
	$where_sql[] = 'u.group_id='.$show_group;
if ($country)
	$where_sql[] = 'u.country_code LIKE \''.$db->escape($country).'\'';
if ($sort_friends && $char)
	$where_sql[] = 'r.user IN (SELECT friend FROM '.$db->prefix.'rscd_friends WHERE user='.$db->escape($char).')';
if ($sort_kills && $char)
	$where_sql[] = 'r.user IN (SELECT killed FROM '.$db->prefix.'rscd_kills WHERE user='.$db->escape($char).')';

// Fetch user count
$result = $db->query('SELECT COUNT(r.user) FROM '.$db->prefix.'rscd_players AS r INNER JOIN '.$db->prefix.'users AS u ON u.id=r.owner WHERE u.id>1 AND u.group_id!='.PUN_ADMIN.(!empty($where_sql) ? ' AND '.implode(' AND ', $where_sql) : '')) or error('Unable to fetch user list count', __FILE__, __LINE__, $db->error());
$num_users = $db->result($result);


// Determine the user offset (based on $_GET['p'])
$num_pages = ceil($num_users / 50);

$p = (!isset($_GET['p']) || $_GET['p'] <= 1 || $_GET['p'] > $num_pages) ? 1 : $_GET['p'];
$start_from = 50 * ($p - 1);

// Generate paging links
$paging_links = $lang_common['Pages'].': '.paginate($num_pages, $p, 'highscores.php?username='.urlencode($username).'&amp;show_group='.$show_group.'&amp;sort_by='.$sort_by.'&amp;sort_dir='.strtoupper($sort_dir).'&amp;skill='.$skill.($country ? '&amp;country='.$country : '').($char ? '&amp;sort_char='.$char : '').($sort_friends ? '&amp;sort_friends=1' : '').($sort_kills ? '&amp;sort_kills=1' : ''));

?>
<div class="linkst">
	<div class="inbox">
		<p class="pagelink"><?php echo $paging_links ?></p>
	</div>
</div>

<div id="users1" class="blocktable">
	<h2><span>Player List</span></h2>
	<div class="box">
		<div class="inbox">
		<table cellspacing="0">
		<thead>
			<tr>
				<th class="tcl" style="width:2%" scope="col">Rank</th>
				<th class="tc2" scope="col">Username</th>
				<th class="tc3" scope="col">Owner</th>
				<th class="tc3" scope="col"><?php echo pun_htmlspecialchars(ucwords($skill)); ?></th>
				<th class="tc3" scope="col"><?php echo $skill == 'combat' || $skill == 'kills' ? 'Skill Total' : 'Experience'; ?></th>
				<th class="tc3" scope="col"><?php echo $lang_common['Registered'] ?></th>
			</tr>
		</thead>
		<tbody>
<?php

// Grab the users
$result = $db->query('SELECT r.*, e.*, COUNT(DISTINCT k.killed) AS kills, u.username AS owner_username, u.country_code AS owner_cc, b.id AS b_id FROM '.$db->prefix.'rscd_players AS r INNER JOIN '.$db->prefix.'rscd_experience AS e ON e.user=r.user LEFT JOIN '.$db->prefix.'users AS u ON u.id=r.owner LEFT JOIN '.$db->prefix.'bans AS b ON b.username LIKE u.username LEFT JOIN '.$db->prefix.'rscd_kills AS k ON k.user=r.user AND k.type=1 WHERE u.id>1 AND u.group_id!='.PUN_ADMIN.(!empty($where_sql) ? ' AND '.implode(' AND ', $where_sql) : '').' GROUP BY r.user ORDER BY '.$sort.' '.$sort_dir.', r.creation_date ASC LIMIT '.$start_from.', 50') or error('Unable to fetch account list: '.mysql_error(), __FILE__, __LINE__, $db->error());
if($db->num_rows($result)) {
	for($rank = $start_from + 1;$char = $db->fetch_assoc($result);$rank++) {
		$flag = pun_htmlspecialchars($char['owner_cc']);
		$exp = extract_exp($char);
		if($exp === false) {
			$exp = $char['skill_total'];
		}
?>
				<tr<?php echo ($char['banned'] == '1' || isset($char['b_id'])) ? ' class="banned"' : ''; ?>>
					<td class="tcl" style="width:2%;text-align:right"><?php echo $rank; ?></td>
					<td class="tc2"><?php echo '<a href="highscores.php?username='.urlencode($username).'&amp;show_group='.$show_group.'&amp;sort_by='.$sort_by.'&amp;sort_dir='.strtoupper($sort_dir).'&amp;skill='.$skill.'&amp;country='.$flag.'"><img src="img/flags/'.$flag.'.gif" alt="'.strtoupper($flag).'" title=" '.strtoupper($flag).' " /></a>&nbsp;&nbsp;<a href="char.php?user='.$char['user'].'">'.pun_htmlspecialchars($char['username']).'</a>'; ?></td>
					<td class="tc3"><?php echo '<a href="profile.php?id='.$char['owner'].'">'.pun_htmlspecialchars($char['owner_username']).'</a>'; ?></td>
					<td class="tc3"><?php echo extract_value($char); ?></td>
					<td class="tc3"><?php echo number_format($exp); ?></td>
					<td class="tc3"><?php echo format_time($char['creation_date'], true); ?></td>
				</tr>
<?php

	}
}
else {
	echo "\t\t\t".'<tr>'."\n\t\t\t\t\t".'<td class="tcl" colspan="6">Your search returned no hits.</td></tr>'."\n";
}

?>
			</tbody>
			</table>
		</div>
	</div>
</div>

<div class="linksb">
	<div class="inbox">
		<p class="pagelink"><?php echo $paging_links ?></p>
	</div>
</div>
<?php

require PUN_ROOT.'footer.php';
