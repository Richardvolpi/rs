<?php

define('PUN_ROOT', '/home/rscd/public_html/');
include PUN_ROOT.'include/base.php';

$stats = array('date' => time());

$result = $db->query('SELECT COUNT(id)-1 FROM '.$db->prefix.'users') or error('Unable to count users', __FILE__, __LINE__, $db->error());
$stats['users'] = $db->result($result);

$result = $db->query('SELECT COUNT(user) FROM '.$db->prefix.'rscd_players') or error('Unable to count players', __FILE__, __LINE__, $db->error());
$stats['players'] = $db->result($result);

$result = $db->query('SELECT SUM(num_topics), SUM(num_posts) FROM '.$db->prefix.'forums') or error('Unable to count topics or posts', __FILE__, __LINE__, $db->error());
list($stats['topics'], $stats['posts']) = $db->fetch_row($result);

$result = $db->query('SELECT COUNT(id) FROM '.$db->prefix.'users WHERE last_visit > UNIX_TIMESTAMP(DATE_SUB(CURDATE(),INTERVAL 1 DAY))') or error('Unable to count active users', __FILE__, __LINE__, $db->error());
$stats['active_users'] = $db->result($result);

$result = $db->query('SELECT COUNT(user) FROM '.$db->prefix.'rscd_players WHERE login_date > UNIX_TIMESTAMP(DATE_SUB(CURDATE(),INTERVAL 1 DAY))') or error('Unable to count active players', __FILE__, __LINE__, $db->error());
$stats['active_players'] = $db->result($result);

// Now we have collected all the required stats, lets insert them to the database
$db->query('INSERT INTO '.$db->prefix.'stats(`date`, `posts`, `topics`, `users`, `players`, `active_users`, `active_players`) VALUES(\''.intval($stats['date']).'\', \''.intval($stats['posts']).'\', \''.intval($stats['topics']).'\', \''.intval($stats['users']).'\', \''.intval($stats['players']).'\', \''.intval($stats['active_users']).'\', \''.intval($stats['active_players']).'\')') or error('Unable to insert stats', __FILE__, __LINE__, $db->error());

// run seperate scripts
include PUN_ROOT.'include/jpgraph/jpgraph.php';
include PUN_ROOT.'include/jpgraph/jpgraph_line.php'; // Line graph

/* START OF USERS GRAPH */
$users = $dates = array();

$result = $db->query('SELECT users FROM '.$db->prefix.'stats ORDER BY date ASC') or error('Unable to fetch user history', __FILE__, __LINE__, $db->error());
while($temp = $db->fetch_row($result)) {
	$users[] = $temp[0];
}
$result = $db->query('SELECT date FROM '.$db->prefix.'stats ORDER BY date ASC') or error('Unable to fetch date history', __FILE__, __LINE__, $db->error());
while($temp = $db->fetch_row($result)) {
	$date[] = date('j M', $temp[0]);
}

// A nice graph with anti-aliasing
$graph = new Graph(600, 200, 'auto');
$graph->img->SetMargin(60, 20 ,20, 60); 
$graph->img->SetAntiAliasing('black');
$graph->SetScale('textlin');
$graph->title->Set('User Count');
$graph->title->SetFont(FF_FONT1, FS_BOLD);
$graph->xaxis->SetTickLabels($date);
$graph->xaxis->SetLabelAngle(90);

$user_plot = new LinePlot($users);
$user_plot->mark->SetType(MARK_STAR);
$user_plot->mark->SetFillColor('black');
$user_plot->mark->SetWidth(4);
$user_plot->SetColor('red');
$user_plot->SetCenter();
$graph->Add($user_plot);

$graph->Stroke(PUN_ROOT.'img/stats/users.png');
/* END OF USERS GRAPH */
/* START OF PLAYERS GRAPH */
$players = $dates = array();

$result = $db->query('SELECT players FROM '.$db->prefix.'stats ORDER BY date ASC') or error('Unable to fetch player history', __FILE__, __LINE__, $db->error());
while($temp = $db->fetch_row($result)) {
	$players[] = $temp[0];
}
$result = $db->query('SELECT date FROM '.$db->prefix.'stats ORDER BY date ASC') or error('Unable to fetch date history', __FILE__, __LINE__, $db->error());
while($temp = $db->fetch_row($result)) {
	$date[] = date('j M', $temp[0]);
}

// A nice graph with anti-aliasing
$graph = new Graph(600, 200, 'auto');
$graph->img->SetMargin(60, 20 ,20, 60); 
$graph->img->SetAntiAliasing('black');
$graph->SetScale('textlin');
$graph->title->Set('Player Count');
$graph->title->SetFont(FF_FONT1, FS_BOLD);
$graph->xaxis->SetTickLabels($date);
$graph->xaxis->SetLabelAngle(90);

$user_plot = new LinePlot($players);
$user_plot->mark->SetType(MARK_STAR);
$user_plot->mark->SetFillColor('black');
$user_plot->mark->SetWidth(4);
$user_plot->SetColor('red');
$user_plot->SetCenter();
$graph->Add($user_plot);

$graph->Stroke(PUN_ROOT.'img/stats/players.png');
/* END OF PLAYERS GRAPH */
/* START OF ACTIVE_USERS GRAPH */
$active = $dates = array();

$result = $db->query('SELECT active_users FROM '.$db->prefix.'stats ORDER BY date ASC') or error('Unable to fetch active history', __FILE__, __LINE__, $db->error());
while($temp = $db->fetch_row($result)) {
	$active[] = $temp[0];
}
$result = $db->query('SELECT date FROM '.$db->prefix.'stats ORDER BY date ASC') or error('Unable to fetch date history', __FILE__, __LINE__, $db->error());
while($temp = $db->fetch_row($result)) {
	$date[] = date('j M', $temp[0]);
}

// A nice graph with anti-aliasing
$graph = new Graph(600, 200, 'auto');
$graph->img->SetMargin(60, 20 ,20, 60); 
$graph->img->SetAntiAliasing('black');
$graph->SetScale('textlin');
$graph->title->Set('Active User Count');
$graph->title->SetFont(FF_FONT1, FS_BOLD);
$graph->xaxis->SetTickLabels($date);
$graph->xaxis->SetLabelAngle(90);

$active_plot = new LinePlot($active);
$active_plot->mark->SetType(MARK_STAR);
$active_plot->mark->SetFillColor('black');
$active_plot->mark->SetWidth(4);
$active_plot->SetColor('red');
$active_plot->SetCenter();
$graph->Add($active_plot);

$graph->Stroke(PUN_ROOT.'img/stats/active_users.png');
/* END OF ACTIVE_USERS GRAPH */
/* START OF ACTIVE_PLAYERS GRAPH */
$active = $dates = array();

$result = $db->query('SELECT active_players FROM '.$db->prefix.'stats ORDER BY date ASC') or error('Unable to fetch active history', __FILE__, __LINE__, $db->error());
while($temp = $db->fetch_row($result)) {
	$active[] = $temp[0];
}
$result = $db->query('SELECT date FROM '.$db->prefix.'stats ORDER BY date ASC') or error('Unable to fetch date history', __FILE__, __LINE__, $db->error());
while($temp = $db->fetch_row($result)) {
	$date[] = date('j M', $temp[0]);
}

// A nice graph with anti-aliasing
$graph = new Graph(600, 200, 'auto');
$graph->img->SetMargin(60, 20 ,20, 60); 
$graph->img->SetAntiAliasing('black');
$graph->SetScale('textlin');
$graph->title->Set('Active Player Count');
$graph->title->SetFont(FF_FONT1, FS_BOLD);
$graph->xaxis->SetTickLabels($date);
$graph->xaxis->SetLabelAngle(90);

$active_plot = new LinePlot($active);
$active_plot->mark->SetType(MARK_STAR);
$active_plot->mark->SetFillColor('black');
$active_plot->mark->SetWidth(4);
$active_plot->SetColor('red');
$active_plot->SetCenter();
$graph->Add($active_plot);

$graph->Stroke(PUN_ROOT.'img/stats/active_players.png');
/* END OF ACTIVE_PLAYERS GRAPH */
/* START OF POSTS GRAPH */
$actual_posts = $count_posts = $dates = array();

$result = $db->query('SELECT posts FROM '.$db->prefix.'stats ORDER BY date ASC') or error('Unable to fetch actual post history', __FILE__, __LINE__, $db->error());
while($temp = $db->fetch_row($result)) {
	$actual_posts[] = $temp[0];
}
$result = $db->query('SELECT date FROM '.$db->prefix.'stats ORDER BY date ASC') or error('Unable to fetch date history', __FILE__, __LINE__, $db->error());
while($temp = $db->fetch_row($result)) {
	$date[] = date('j M', $temp[0]);
}

// A nice graph with anti-aliasing
$graph = new Graph(600, 200, 'auto');
$graph->img->SetMargin(60, 20 ,20, 60); 
$graph->img->SetAntiAliasing('black');
$graph->SetScale('textlin');
$graph->title->Set('Post Count');
$graph->title->SetFont(FF_FONT1, FS_BOLD);
$graph->xaxis->SetTickLabels($date);
$graph->xaxis->SetLabelAngle(90);

$actual_plot = new LinePlot($actual_posts);
$actual_plot->mark->SetType(MARK_STAR);
$actual_plot->mark->SetFillColor('black');
$actual_plot->mark->SetWidth(4);
$actual_plot->SetColor('red');
$actual_plot->SetCenter();
$graph->Add($actual_plot);

$graph->Stroke(PUN_ROOT.'img/stats/posts.png');
/* END OF POSTS GRAPH */
/* START OF TOPICS GRAPH */
$topics = $dates = array();

$result = $db->query('SELECT topics FROM '.$db->prefix.'stats ORDER BY date ASC') or error('Unable to fetch topic history', __FILE__, __LINE__, $db->error());
while($temp = $db->fetch_row($result)) {
	$topics[] = $temp[0];
}
$result = $db->query('SELECT date FROM '.$db->prefix.'stats ORDER BY date ASC') or error('Unable to fetch date history', __FILE__, __LINE__, $db->error());
while($temp = $db->fetch_row($result)) {
	$date[] = date('j M', $temp[0]);
}

// A nice graph with anti-aliasing
$graph = new Graph(600, 200, 'auto');
$graph->img->SetMargin(60, 20 ,20, 60); 
$graph->img->SetAntiAliasing('black');
$graph->SetScale('textlin');
$graph->title->Set('Topic Count');
$graph->title->SetFont(FF_FONT1, FS_BOLD);
$graph->xaxis->SetTickLabels($date);
$graph->xaxis->SetLabelAngle(90);

$topic_plot = new LinePlot($topics);
$topic_plot->mark->SetType(MARK_STAR);
$topic_plot->mark->SetFillColor('black');
$topic_plot->mark->SetWidth(4);
$topic_plot->SetColor('red');
$topic_plot->SetCenter();
$graph->Add($topic_plot);

$graph->Stroke(PUN_ROOT.'img/stats/topics.png');
/* END OF TOPICS GRAPH */

$db->close();
exit('Finished'."\n");
