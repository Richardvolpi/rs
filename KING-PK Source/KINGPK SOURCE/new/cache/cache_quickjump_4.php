<?php

if (!defined('PUN')) exit;
define('PUN_QJ_LOADED', 1);

?>				<form id="qjump" method="get" action="viewforum.php">
					<div><label><?php echo $lang_common['Jump to'] ?>

					<br /><select name="id" onchange="window.location=('viewforum.php?id='+this.options[this.selectedIndex].value)">
						<optgroup label="Announcements">
							<option value="2"<?php echo ($forum_id == 2) ? ' selected="selected"' : '' ?>>Announcements</option>
							<option value="18"<?php echo ($forum_id == 18) ? ' selected="selected"' : '' ?>>Update Logs</option>
							<option value="3"<?php echo ($forum_id == 3) ? ' selected="selected"' : '' ?>>Latest Client</option>
							<option value="4"<?php echo ($forum_id == 4) ? ' selected="selected"' : '' ?>>Suggestions</option>
						</optgroup>
						<optgroup label="General King Pk">
							<option value="6"<?php echo ($forum_id == 6) ? ' selected="selected"' : '' ?>>General</option>
							<option value="21"<?php echo ($forum_id == 21) ? ' selected="selected"' : '' ?>>Events</option>
							<option value="5"<?php echo ($forum_id == 5) ? ' selected="selected"' : '' ?>>Market</option>
							<option value="7"<?php echo ($forum_id == 7) ? ' selected="selected"' : '' ?>>Player Killz</option>
							<option value="8"<?php echo ($forum_id == 8) ? ' selected="selected"' : '' ?>>Bank-Stat Pics</option>
						</optgroup>
						<optgroup label="Clans">
							<option value="9"<?php echo ($forum_id == 9) ? ' selected="selected"' : '' ?>>Clan wars</option>
							<option value="10"<?php echo ($forum_id == 10) ? ' selected="selected"' : '' ?>>Recruiting</option>
						</optgroup>
						<optgroup label="Off Topic">
							<option value="11"<?php echo ($forum_id == 11) ? ' selected="selected"' : '' ?>>Off Topic</option>
							<option value="12"<?php echo ($forum_id == 12) ? ' selected="selected"' : '' ?>>RL Pictures</option>
							<option value="13"<?php echo ($forum_id == 13) ? ' selected="selected"' : '' ?>>GFX</option>
							<option value="19"<?php echo ($forum_id == 19) ? ' selected="selected"' : '' ?>>Retard's postings./ SPAM</option>
						</optgroup>
						<optgroup label="Ban Appeals/ Apps">
							<option value="20"<?php echo ($forum_id == 20) ? ' selected="selected"' : '' ?>>Event Coordinators App</option>
							<option value="14"<?php echo ($forum_id == 14) ? ' selected="selected"' : '' ?>>Ban Appeals</option>
							<option value="15"<?php echo ($forum_id == 15) ? ' selected="selected"' : '' ?>>Mod Apps</option>
							<option value="16"<?php echo ($forum_id == 16) ? ' selected="selected"' : '' ?>>Proccessing..</option>
					</optgroup>
					</select>
					<input type="submit" value="<?php echo $lang_common['Go'] ?>" accesskey="g" />
					</label></div>
				</form>
