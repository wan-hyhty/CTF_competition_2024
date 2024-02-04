import xml.etree.ElementTree as ET
import sys
import requests
import threading
dirsearch = ['/100', '/200', '/2001', '/2002', '/2003', '/2000', '/2005', '/2004', '/2006', '/2007', '/101', '/2009', '/2008', '/500', '/a4j/s/3_3_3.Finalorg/richfaces/renderkit/html/css/basic_classes.xcss/DATB/', '/academic', '/about', '/abcd1234', '/accessibility', '/adfs/services/trust/2005/windowstransport', '/addressbook', 'dev/', '/admin2007/', '/admin2009/', '/admin2009', '/admin2007', '/admin2006/', '/admin2008/', '/admin2008', '/adminpanel', '/adminpanel/', '/apidocs', '/assets', '/assets/', 'end/', '/backup0/', '/backoffice', '/backoffice/', '/books', '/borat', '/cacti', '/camunda', '/careers', '/ckeditor', '/ckeditor/', '/configs/', '/datadog/', '/disclaimer', '/donate', '/education', '/eticket', '/file_manager', '/file_manager/', '/giveadmin', '/graphiql/', '/json', '/mailadmin', '/mailman', '/mailman/', '/mainadmin', '/mambots', '/manuallogin/', '/map_admin', '/mapping', '/masteradmin', '/media_admin', 'login', '/memberadmin', '/memberadmin/', '/membersonly', '/memlogin/', '/metaadmin', '/mfr_admin', '/mliveadmin', '/mmwip', '/modcp', '/modelsearch/', '/moderator', '/moderator/', '/modules_admin', '/monitor', '/monitor/', '/more', '/msadc/', '/music', 'admin', '/my_admin', '/myadm/', '/myconfigs/', '/myphpadmin', 'admin', 'admin/', '/mysql_admin', '/mysqldumper/', '/nadmin', '/nbproject/', '/new_admin', '/newadmin', 'admin', '/news_admin', '/newsadmin', '/newsadmin/', '/newsletteradmin', '/nimda/', '/ntadmin', '/nusoap', '/old_admin', '/old_site/', '/oldadmin', '/oneadmin', '/openvpnadmin/', '/operador/', '/osadmin', '/oscommerce', '/padmin', '/papers', '/passwd', '/passwd/', '/pause', 'admin', '/pbmadmin', '/pbadmin', '/pbmadmin/', 'bin/', '/phpinfo', '/phpldapadmin', '/phpldapadmin/', '/phpma/', '/phpmailer', '/phpmy/', '/phpmyadmin', '/phpmyadmin/', '/phpmyadmin3/', '/phpmyadmin3', '/phppgadmin', '/phppgadmin/', '/phpsecinfo', '/phpsecinfo/', '/phpsysinfo/', '/pipermail', '/pkginfo', 'stat', 'ssl/', '/webstat/', '/pma2005', '/pma2005/', '/pma2009/', '/pmadmin', '/pmadmin/', '/podcasts_admin', '/portal2', '/portaladmin', '/postfixadmin', '/press', '/printenv', '/printer', '/processlogin', 'admins/', '/pub', '/pureadmin/', '/qmailadmin', '/radmin', '1/', '/radmind/', '/rap_admin', '/recoverpassword', '/redis/', '/sadmin', '/scheduledtasks', '/search_admin', '/servicedesk', '/share', '/share/', '/sign_in', '/sign_in/', '/sitemap', '/smblogin/', '/smilies', '/snp', '/soapdocs/', '/sohoadmin', 'admin/', '/squirrelmail', '/srchadm', '/sshadmin/', '/sspadmin', '/sswadmin', '/staradmin/', '/statusicon/', '/statystyka/', 'admin', '/storeadmin', '/stories', 'login/', '/subadmin', '/supervise/', '/surveyadmin', '/swfupload', 'admin', 'admin/', '/sysadm', '/sysadm/', '/sysadmins', '/sysadmins/', 'administration/', '/systemadmin', '/tadmin', '/templates_c', '/templates_c/', '/templets', '/test0', '/textpattern/', 'admin', '/tikiwiki', '/tiny_mce', '/tiny_mce/', '/topicadmin', '/trackback', '/tsweb', '/tsweb/', '/tttadmin', '/typo3_src', '/typo3temp/', '/uddi', '/uploadify', '/uploadify/', '/uploads_admin', 'admin', 'admin/', '/user_admin', '/user_guide', '/usercp', '/userdb', '/userlogin', '/vadmin', '/vadmind/', '/vendors/', 'source', '/vignettes/', '/vmailadmin/', 'console/', '/webstat', '/webstats', '/webstats/', '/wizmysqladmin/', 'admin', 'admin/', 'includes', 'includes/', 'login', 'login/', 'register', 'rss2', '/wstats', 'test/', '/wwwboard/', '/wwwlog', '/wwwstat', '/xlogin/', '/xmlrpc', '/xsql/', '/yonetici', '/yonetim']

def search(idx_dirsearch):
    url = "https://storage.googleapis.com" + idx_dirsearch  # Thay thế URL bằng địa chỉ trang web bạn muốn lấy nội dung
    response = requests.get(url)
    content = response.content  # Lấy nội dung từ phản hồi

    root = ET.fromstring(content)
    ns = {"ns": "http://doc.s3.amazonaws.com/2006-03-01"}
    key_elements = root.findall(".//ns:Key", ns)
    path = []
    for key_element in key_elements:
        key_value = key_element.text.replace(" ", "%20")
        path.append(key_value)
    for i in path:
        url = "https://storage.googleapis.com" + idx_dirsearch  + i  # Thay thế URL bằng địa chỉ trang web bạn muốn lấy nội dung
        response = requests.get(url)
        if b"Error" not in response.content:
            print(url)       
            
for i in range(0, len(dirsearch)):
    thread = threading.Thread(target=search, args=(dirsearch[i],))
    thread.start()