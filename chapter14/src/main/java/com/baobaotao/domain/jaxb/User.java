//
// 此文件是由 JavaTM Architecture for XML Binding (JAXB) 引用实现 v2.2.8-b130911.1802 生成的
// 请访问 <a href="http://java.sun.com/xml/jaxb">http://java.sun.com/xml/jaxb</a> 
// 在重新编译源模式时, 对此文件的所有修改都将丢失。
// 生成时间: 2020.01.28 时间 08:28:20 PM CST 
//


package com.baobaotao.domain.jaxb;

import java.util.ArrayList;
import java.util.List;
import javax.xml.bind.annotation.XmlAccessType;
import javax.xml.bind.annotation.XmlAccessorType;
import javax.xml.bind.annotation.XmlAttribute;
import javax.xml.bind.annotation.XmlElement;
import javax.xml.bind.annotation.XmlRootElement;
import javax.xml.bind.annotation.XmlType;


/**
 * <p>anonymous complex type的 Java 类。
 * 
 * <p>以下模式片段指定包含在此类中的预期内容。
 * 
 * <pre>
 * &lt;complexType>
 *   &lt;complexContent>
 *     &lt;restriction base="{http://www.w3.org/2001/XMLSchema}anyType">
 *       &lt;sequence>
 *         &lt;element name="userName" type="{http://www.w3.org/2001/XMLSchema}string"/>
 *         &lt;element name="password" type="{http://www.w3.org/2001/XMLSchema}string"/>
 *         &lt;element name="credits" type="{http://www.w3.org/2001/XMLSchema}int"/>
 *         &lt;element name="lastIp" type="{http://www.w3.org/2001/XMLSchema}string"/>
 *         &lt;element name="logs">
 *           &lt;complexType>
 *             &lt;complexContent>
 *               &lt;restriction base="{http://www.w3.org/2001/XMLSchema}anyType">
 *                 &lt;sequence>
 *                   &lt;element name="loginLog" type="{http://www.baobaotao.com/domain/jaxb}LoginLog" maxOccurs="unbounded"/>
 *                 &lt;/sequence>
 *               &lt;/restriction>
 *             &lt;/complexContent>
 *           &lt;/complexType>
 *         &lt;/element>
 *       &lt;/sequence>
 *       &lt;attribute name="userId" type="{http://www.w3.org/2001/XMLSchema}int" />
 *     &lt;/restriction>
 *   &lt;/complexContent>
 * &lt;/complexType>
 * </pre>
 * 
 * 
 */
@XmlAccessorType(XmlAccessType.FIELD)
@XmlType(name = "", propOrder = {
    "userName",
    "password",
    "credits",
    "lastIp",
    "logs"
})
@XmlRootElement(name = "user")
public class User {

    @XmlElement(required = true)
    protected String userName;
    @XmlElement(required = true)
    protected String password;
    protected int credits;
    @XmlElement(required = true)
    protected String lastIp;
    @XmlElement(required = true)
    protected User.Logs logs;
    @XmlAttribute(name = "userId")
    protected Integer userId;

    /**
     * 获取userName属性的值。
     * 
     * @return
     *     possible object is
     *     {@link String }
     *     
     */
    public String getUserName() {
        return userName;
    }

    /**
     * 设置userName属性的值。
     * 
     * @param value
     *     allowed object is
     *     {@link String }
     *     
     */
    public void setUserName(String value) {
        this.userName = value;
    }

    /**
     * 获取password属性的值。
     * 
     * @return
     *     possible object is
     *     {@link String }
     *     
     */
    public String getPassword() {
        return password;
    }

    /**
     * 设置password属性的值。
     * 
     * @param value
     *     allowed object is
     *     {@link String }
     *     
     */
    public void setPassword(String value) {
        this.password = value;
    }

    /**
     * 获取credits属性的值。
     * 
     */
    public int getCredits() {
        return credits;
    }

    /**
     * 设置credits属性的值。
     * 
     */
    public void setCredits(int value) {
        this.credits = value;
    }

    /**
     * 获取lastIp属性的值。
     * 
     * @return
     *     possible object is
     *     {@link String }
     *     
     */
    public String getLastIp() {
        return lastIp;
    }

    /**
     * 设置lastIp属性的值。
     * 
     * @param value
     *     allowed object is
     *     {@link String }
     *     
     */
    public void setLastIp(String value) {
        this.lastIp = value;
    }

    /**
     * 获取logs属性的值。
     * 
     * @return
     *     possible object is
     *     {@link User.Logs }
     *     
     */
    public User.Logs getLogs() {
        return logs;
    }

    /**
     * 设置logs属性的值。
     * 
     * @param value
     *     allowed object is
     *     {@link User.Logs }
     *     
     */
    public void setLogs(User.Logs value) {
        this.logs = value;
    }

    /**
     * 获取userId属性的值。
     * 
     * @return
     *     possible object is
     *     {@link Integer }
     *     
     */
    public Integer getUserId() {
        return userId;
    }

    /**
     * 设置userId属性的值。
     * 
     * @param value
     *     allowed object is
     *     {@link Integer }
     *     
     */
    public void setUserId(Integer value) {
        this.userId = value;
    }


    /**
     * <p>anonymous complex type的 Java 类。
     * 
     * <p>以下模式片段指定包含在此类中的预期内容。
     * 
     * <pre>
     * &lt;complexType>
     *   &lt;complexContent>
     *     &lt;restriction base="{http://www.w3.org/2001/XMLSchema}anyType">
     *       &lt;sequence>
     *         &lt;element name="loginLog" type="{http://www.baobaotao.com/domain/jaxb}LoginLog" maxOccurs="unbounded"/>
     *       &lt;/sequence>
     *     &lt;/restriction>
     *   &lt;/complexContent>
     * &lt;/complexType>
     * </pre>
     * 
     * 
     */
    @XmlAccessorType(XmlAccessType.FIELD)
    @XmlType(name = "", propOrder = {
        "loginLog"
    })
    public static class Logs {

        @XmlElement(required = true)
        protected List<LoginLog> loginLog;

        /**
         * Gets the value of the loginLog property.
         * 
         * <p>
         * This accessor method returns a reference to the live list,
         * not a snapshot. Therefore any modification you make to the
         * returned list will be present inside the JAXB object.
         * This is why there is not a <CODE>set</CODE> method for the loginLog property.
         * 
         * <p>
         * For example, to add a new item, do as follows:
         * <pre>
         *    getLoginLog().add(newItem);
         * </pre>
         * 
         * 
         * <p>
         * Objects of the following type(s) are allowed in the list
         * {@link LoginLog }
         * 
         * 
         */
        public List<LoginLog> getLoginLog() {
            if (loginLog == null) {
                loginLog = new ArrayList<LoginLog>();
            }
            return this.loginLog;
        }

    }

}
