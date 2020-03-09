package com.shell.manage.service.serviceImpl;
import ch.ethz.ssh2.Session;
import com.shell.manage.service.ManageShell;
import com.shell.manage.service.SSHRemoteCall;
import org.springframework.stereotype.Service;

import java.io.BufferedReader;
import java.io.InputStream;
import java.io.InputStreamReader;
import java.nio.charset.Charset;
import java.util.ArrayList;
import java.util.List;

@Service
public class ManageShellmpl implements ManageShell {


    private static final int DEFAULT_PORT = 22;// 默认端口号
    private int port;// 端口号

    private static String ipAddress = "192.168.48.131";// ip地址
    private static String userName = "root";// 账号
    private static String password = "root";// 密码
    private Session session;// JSCH session
    private boolean logined = false;// 是否登陆

    @Override
//    public void runShell() {
//        try {
//            List<String> result = new ArrayList<String>();
//            Connection connection = new Connection(ipAddress);
//            connection.connect();//连接
//            connection.authenticateWithPassword(userName,password);//认证
//            Session session = connection.openSession();
//            session.execCommand(". /michael/michael.sh");
//            InputStream is = new StreamGobbler(session.getStdout());//获得标准输出流
//            BufferedReader brs = new BufferedReader(new InputStreamReader(is, Charset.forName("UTF-8")));
//            String temp = "";
//            while ((temp = brs.readLine()) != null) {
//                String[] a = temp.split("\\s+");
//                if (a.length > 7) {
//                    result.add(a[a.length - 1]);
//                }
//            }
//            System.out.println(result);
//            if (session != null) {
//                session.close();
//            }
//            session.close();
//            brs.close();
//        }catch (Exception e){
//            System.err.println("脚本运行失败......");
//            e.printStackTrace();
//        }
//}

    public void runShell(){
        try {
            if(session!=null){
                SSHRemoteCall.getInstance().closeSession();
            }else{
                SSHRemoteCall.getInstance().sshRemoteCallLogin(ipAddress, userName, password);
                // 1、首先远程连接ssh
                // 打印信息
                System.out.println("0、连接192.168.48.130,ip地址: " + ipAddress + ",账号: " + userName + ",连接成功.....");
                String command = ". /michael/michael.sh";
                SSHRemoteCall.getInstance().execCommand(command);
            }

        } catch (Exception e) {
            // 打印错误信息
            System.err.println("远程连接失败......");
            e.printStackTrace();

        }
    }

    @Override
    public void downloadFile() {
        try {
            if(session!=null){
                SSHRemoteCall.getInstance().closeSession();
            }else{
                SSHRemoteCall.getInstance().sshRemoteCallLogin(ipAddress, userName, password);
                // 1、首先远程连接ssh
                // 打印信息
                System.out.println("0、连接192.168.48.130,ip地址: " + ipAddress + ",账号: " + userName + ",连接成功.....");
//                String command = "free ";
//                SSHRemoteCall.getInstance().execCommand(command);
                String src = "/michael/michael.csv";
                String dst = "C:/Users/HP/Desktop";
                SSHRemoteCall.getInstance().fileDownload(src, dst);
                // 6、展示目录下的文件信息
                String lsDirectory = "/michael/michael.csv";
                SSHRemoteCall.getInstance().listFiles(lsDirectory);
            }

        } catch (Exception e) {
            // 打印错误信息
            System.err.println("远程连接失败......");
            e.printStackTrace();

        }

    }
    }

