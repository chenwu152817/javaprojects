微信测试号appID：wx5805c9dd2aa31613

微信测试号appsecret：12a4811837f448502b4515bfbb8c1a4d

回调服务器：sellfood.natapp1.cc

改虚拟机的服务器配置映射到本地：vim /usr/local/nginx/conf/nginx.conf

改静态域名：vi /etc/sysconfig/network-scripts/ifcfg-eth0

改hosts文件

改服务器发送信息到本地服务器获取openid
sellfood.natapp1.cc/sell/wechat/qrAuthorize?returnUrl=http://www.baidu.com
改redis地址

打开三个服务器
虚拟机
IDEA
映射NETAPP
Spring的快速复制对象BeanUtils.copyProperties(productInfo,productInfoVO);
获得对象列表List<Integer> categoryTypeList =
        productInfoList.stream()
                .map(e->e.getCategoryType())
                .collect(Collectors.toList());
百度下载
以下是您订购的订单68628724509156205的内容请注意查收：
账号：xz127t密码：d65hd
★务必用电脑复制该链接到浏览器http://139.224.236.108/ 既不需要绑定手机号码也不会被封号，快速下载好文档，超方便
IDEA把ftl文件格式变成text格式
解决办法
https://liuyanzhao.com/7839.html
JQUARY下载地址
http://www.jb51.net/zt/jquerydown.htm
Oracle：
accept num;接收从键盘的输入值
num 地址值 含义：在该地址上保存了值
所以赋值的时候要写:=&num
3类循环
比如打印1-10的数字
While循环
declare
  pnum number:=1;
begin
  while punm<10 loop
     dbms_output.put_line(pnum);
     pnum:=pnum+1;
  end loop;
end;

Loop循环
declare
  pnum number:=1;
begin
  loop
   exit when punm>10;
dbms_output.put_line(pnum);
     pnum:=pnum+1;
  end loop
end

For循环
declare
  pnum number:=1;
begin
  for punm in 1..10 loop
  dbms_output.put_line(pnum);
  pnum:=pnum+1;
end
游标的属性
%found 有语句为true
%notfound 无语句为ture
%isopen 打开为ture
%rowcount 影响行数 fetch过的行数
使用时候
光标名%found