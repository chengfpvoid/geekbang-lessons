package org.geektimes.projects.user.web.listener;

import org.geektimes.projects.user.domain.User;
import org.geektimes.projects.user.management.UserManager;
import org.geektimes.projects.user.management.UserManagerMBean;

import javax.management.MBeanServer;
import javax.management.NotCompliantMBeanException;
import javax.management.ObjectName;
import javax.management.StandardMBean;
import javax.servlet.ServletContextEvent;
import javax.servlet.ServletContextListener;
import java.lang.management.ManagementFactory;

public class JmxBeanListener implements ServletContextListener {

    @Override
    public void contextInitialized(ServletContextEvent servletContextEvent) {

        // 将静态的 MBean 接口转化成 DynamicMBean
        try {
            User user = new User();
            user.setId(1L);
            user.setName("chengfpvoid");
            user.setEmail("chengfpvoid@gmail.com");
            user.setPhoneNumber("123456789101");
            user.setPassword("......");
            MBeanServer mBeanServer = ManagementFactory.getPlatformMBeanServer();
            // 为 UserMXBean 定义 ObjectName
            ObjectName objectName = new ObjectName("org.geektimes.projects.user.management:type=User");
            // 创建 UserMBean 实例
            // 将静态的 MBean 接口转化成 DynamicMBean
            StandardMBean standardMBean = new StandardMBean(new UserManager(user), UserManagerMBean.class);

            mBeanServer.registerMBean(standardMBean, objectName);
        } catch (Exception e) {
            e.printStackTrace();
        }


    }

    @Override
    public void contextDestroyed(ServletContextEvent servletContextEvent) {

    }
}
