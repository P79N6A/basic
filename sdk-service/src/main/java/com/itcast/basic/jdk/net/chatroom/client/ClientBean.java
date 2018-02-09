package com.itcast.basic.jdk.net.chatroom.client;

import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

public class ClientBean extends Frame implements ActionListener {

    private JButton jb1, jb2;
    private JTextField jtf1, jtf2, jtf3;
    private JTextArea jta;
    private JPanel jp1, jp3;
    private JLabel jl1, jl2;
    private JScrollPane jsp;

    public ClientBean() {
        init();
    }

    public JTextArea getJTextArea() {
        return jta;
    }

    private void init() {
        initView();
        this.setLayout(new GridLayout(3, 1));
        this.add(jp1);
        this.add(jsp);
        this.add(jp3);
        this.setTitle("qq通信");
        this.setSize(500, 300);
        this.setLocation(800, 150);
        this.setVisible(true);
    }

    private void initView() {
        jp1 = new JPanel();

        jl1 = new JLabel("域名ַ");
        jl2 = new JLabel("端口");
        jtf1 = new JTextField(10);
        jtf1.setText("127.0.0.1");
        jtf2 = new JTextField(10);
        jtf2.setText("2000");
        jb1 = new JButton("连接服务器");
        jb1.setActionCommand("open");
        jb1.addActionListener(this);
        jp1.add(jl1);
        jp1.add(jtf1);
        jp1.add(jl2);
        jp1.add(jtf2);
        jp1.add(jb1);


        jta = new JTextArea();
        jsp = new JScrollPane(jta);

        jp3 = new JPanel();
        jtf3 = new JTextField(10);
        jb2 = new JButton("发送");
        jb2.setActionCommand("send");
        jb2.addActionListener(this);
        jp3.add(jtf3);
        jp3.add(jb2);

    }

    public void appendTest(String text) {
        jta.append(text);
    }

    @Override
    public void actionPerformed(ActionEvent e) {
        if (e.getActionCommand().equals("open")) {
            String host = jtf1.getText();
            int port = Integer.parseInt((jtf2.getText().equals("") ? "0" : jtf2.getText()));
            if (!host.equals("") && port != 0) {
                ClientBeanUtils.getInstance().connect(host, port);
                this.jb1.setEnabled(false);
            }

        } else if (e.getActionCommand().equals("send")) {
            String text = jtf3.getText();
            if (!text.equals("")) {
                ClientBeanUtils.getInstance().send(text);
                appendTest("我说 " + text);
                jtf3.setText("");
            }

        }
    }

}
