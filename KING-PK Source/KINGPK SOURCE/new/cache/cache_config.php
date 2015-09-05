<?php

define('PUN_CONFIG_LOADED', 1);

$pun_config = array (
  'o_cur_version' => '1.2.17',
  'o_board_title' => 'King Pk F2P',
  'o_board_desc' => 'RSC F2P Private Server',
  'o_server_timezone' => '0',
  'o_time_format' => 'H:i:s',
  'o_date_format' => 'Y-m-d',
  'o_timeout_visit' => '600',
  'o_timeout_online' => '300',
  'o_redirect_delay' => '1',
  'o_show_version' => '0',
  'o_show_user_info' => '1',
  'o_show_post_count' => '1',
  'o_smilies' => '1',
  'o_smilies_sig' => '1',
  'o_make_links' => '1',
  'o_default_lang' => 'English',
  'o_default_style' => 'Midievo',
  'o_default_user_group' => '4',
  'o_topic_review' => '15',
  'o_disp_topics_default' => '30',
  'o_disp_posts_default' => '25',
  'o_indent_num_spaces' => '4',
  'o_quickpost' => '1',
  'o_users_online' => '1',
  'o_censoring' => '0',
  'o_ranks' => '1',
  'o_show_dot' => '0',
  'o_quickjump' => '1',
  'o_gzip' => '0',
  'o_additional_navlinks' => NULL,
  'o_report_method' => '0',
  'o_regs_report' => '0',
  'o_mailing_list' => 'askeric@live.com',
  'o_avatars' => '1',
  'o_avatars_dir' => 'img/avatars',
  'o_avatars_width' => '60',
  'o_avatars_height' => '60',
  'o_avatars_size' => '10240',
  'o_search_all_forums' => '1',
  'o_base_url' => 'http://king-pk.com',
  'o_admin_email' => 'askeic@live.com',
  'o_webmaster_email' => 'askeric@live.com',
  'o_subscriptions' => '1',
  'o_smtp_host' => NULL,
  'o_smtp_user' => NULL,
  'o_smtp_pass' => NULL,
  'o_regs_allow' => '1',
  'o_regs_verify' => '0',
  'o_announcement' => '1',
  'o_announcement_message' => '<form action="https://www.paypal.com/cgi-bin/webscr" method="post">
<input type="hidden" name="cmd" value="_s-xclick">
<input type="hidden" name="encrypted" value="-----BEGIN PKCS7-----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-----END PKCS7-----
">
<input type="image" src="https://www.paypal.com/en_US/i/btn/btn_donateCC_LG.gif" border="0" name="submit" alt="">
<img alt="" border="0" src="https://www.paypal.com/en_US/i/scr/pixel.gif" width="1" height="1">
</form>

<br> Keep the server running
<br><a href="http://74.213.170.38/KingPK F2P V2.rar">GET THE CLIENT HERE AND JOIN UP!</a><br>
<br>
<a href="http://uppit.com/LTEOJK">ALT Client DL Link!</a><br>
<br>

<br>
<a href="http://74.213.170.38/viewtopic.php?id=88">Offical King PK Read Me!</a><br>
<BR>
 <a href="http://74.213.170.38/viewtopic.php?id=216
">EVENT PRIZE PRICES AND RULES!</a><br>
<br>
 <a href="http://74.213.170.38/viewtopic.php?id=33
">NEW DONATION DETAILS!</a>
<BR>
<br><a href="http://z13.invisionfree.com/KING_PK/index.php?act=idx">JOIN THE ALT KINGPK COMMUNITY NOW TO STAY UP TO DATE IF EVER GOES DOWN!</a><br>
<a href="http://74.213.170.38/index.php"><img src="http://img368.imageshack.us/img368/1860/staffif7.png" border="0" alt="Image Hosted by ImageShack.us"/></a>
<br>',
  'o_rules' => '0',
  'o_rules_message' => '<p>In order to keep the forums running well and to prevent any problems, please follow these simple rules for the forums here. You must agree to this set of rules before using our forum. If you have any questions or problems, please feel free to contact one of the Staff Members.</p>

<ul class="rules">
	<li>While debating and discussion is fine, we will not tolerate rudeness, insulting posts, personal attacks or purposeless inflammatory posts. Our decision is final in these matters.</li>
	<li>Spamming is not tolerated. This includes meaningless threads, one word (or short) non-sense posts. Multiple or repeated posting in order to increase your post count is not allowed. Take care to post threads in the right forum.</li>
	<li>Trading and/or selling of items or services for real currency is not permitted, without the prior consent from an Admin.</li>
	<li>Advertising is not allowed, without prior consent from an Admin. This includes using the forum email and Private message system to spam other members. No money pyramid schemes, or referral schemes. Also, we would appreciate it if you refrain from blatant bashing of our or any other boards.</li>
	<li>Each member is allowed one login account. Registering with multiple accounts is not allowed.</li>
	<li>Do not have overly large signatures. A recommended size for an image signature is no larger then 400x200.</li>
	<li>We have the right to remove any posts or threads which we deem to be rule breaking, without notice.</li>
	<li>We also reserve the right to ban anyone who breaks the forum rules, as access to our forums is a privilege, not a right.</li>
	<li>Staff are exempt from any rules if they deem it necessary. If you find any of the staff\'s actions offensive, please send a private message to an Admin detailing your problem.</li>
	<li>Stickies are made for a reason, always read them before posting.</li>
	<li>Ban evasions will lead to longer bans. Don\'t waste your time proxying.</li>
	<li>If you see any rule breaking, please use the report button allocated at the bottom right of every post.</li>
	<li>Most rule breaking will result in a warning or a temporary ban, if continued, you will receive a permanent ban.</li>
 	<li>While there is a high diversity of users here, the main language is English and all posts should be in English only.</li>
</ul>

<p>While these rules cover most common situations, they cannot anticipate everything. Consequently we reserve the right to take any actions we deem appropriate to ensure these forums are not disrupted or abused in any way.</p>',
  'o_maintenance' => '0',
  'o_maintenance_message' => '<p>Forum is going to be offline for 10-15 minutes as I update a newer version of the skin... Not final version... but newer.<br><br>
:-) Please bear with me.</p>',
  'p_mod_edit_users' => '1',
  'p_mod_rename_users' => '0',
  'p_mod_change_passwords' => '0',
  'p_mod_ban_users' => '0',
  'p_message_bbcode' => '1',
  'p_message_img_tag' => '1',
  'p_message_all_caps' => '1',
  'p_subject_all_caps' => '1',
  'p_sig_all_caps' => '1',
  'p_sig_bbcode' => '1',
  'p_sig_img_tag' => '1',
  'p_sig_length' => '400',
  'p_sig_lines' => '4',
  'p_allow_banned_email' => '0',
  'p_allow_dupe_email' => '0',
  'p_force_guest_email' => '1',
);

?>