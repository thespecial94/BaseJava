package com.basejava.webapp;

import com.basejava.webapp.model.*;
import com.basejava.webapp.util.DateUtil;

import java.time.Month;
import java.util.ArrayList;
import java.util.List;

public class ResumeTestData {

    public static void main(String[] args) {
        createResume("uuid", "Григорий Кислин");
    }

    public static Resume createResume(String uuid, String fullName) {
        Resume resume = new Resume(uuid, fullName);
        resume.setContact(ContactType.PHONE, "+7(921) 855-0482");
        resume.setContact(ContactType.MOBILE, "No info");
        resume.setContact(ContactType.HOME_PHONE, "No info");
        resume.setContact(ContactType.SKYPE, "skype:grigory.kislin");
        resume.setContact(ContactType.EMAIL, "gkislin@yandex.ru");
        resume.setContact(ContactType.LINKEDIN, "LinkedIn");
        resume.setContact(ContactType.GITHUB, "GitHub");
        resume.setContact(ContactType.STACKOVERFLOW, "Stackoverflow");
        resume.setContact(ContactType.PAGE_HOME, "Домашняя страница!!!");

        resume.setSection(SectionType.OBJECTIVE, new TextSection("Ведущий стажировок и корпоративного обучения " +
                "по Java Web и Enterprise технологиям"));
        resume.setSection(SectionType.PERSONAL, new TextSection("Аналитический склад ума, сильная логика, " +
                "креативность, инициативность. Пурист кода и архитектуры."));

        ListSection listAchievementSection = getAchievementSection();
        resume.setSection(SectionType.ACHIEVEMENT, listAchievementSection);

        ListSection listQualificationsSection = getQualificationsSection();
        resume.setSection(SectionType.QUALIFICATIONS, listQualificationsSection);
//
//
//        resume.setSection(SectionType.EXPERIENCE, getExperienceSection());
//
//        resume.setSection(SectionType.EDUCATION, getEducationSection());

        System.out.println(resume.getFullName());
        for (ContactType type : ContactType.values()) {
            System.out.println(type.getContact());
            System.out.println(resume.getContact(type));
        }

        for (SectionType type : SectionType.values()) {
            System.out.println(type.getTitle());
            System.out.println(resume.getSection(type));
        }
        return resume;
    }

    private static ListSection getAchievementSection() {
        List<String> list = new ArrayList<>();
        list.add("Организация команды и успешная реализация Java проектов для сторонних заказчиков: " +
                "приложения автопарк на стеке Spring Cloud/микросервисы, система мониторинга " +
                "показателей спортсменов на Spring Boot, участие в проекте МЭШ на Play-2, " +
                "многомодульный Spring Boot + Vaadin проект для комплексных DIY смет");
        list.add("С 2013 года: разработка проектов \"Разработка Web приложения\",\"Java Enterprise\"," +
                " \"Многомодульный" + " maven. Многопоточность. XML (JAXB/StAX). Веб сервисы (JAX-RS/SOAP). " +
                "Удаленное взаимодействие (JMS/AKKA)\". Организация онлайн стажировок и ведение проектов. " +
                "Более 3500 выпускников.");
        list.add("Реализация двухфакторной аутентификации для онлайн платформы управления проектами Wrike. " +
                "Интеграция с Twilio, DuoSecurity, Google Authenticator, Jira, Zendesk.");
        list.add("Налаживание процесса разработки и непрерывной интеграции ERP системы River BPM." +
                " Интеграция с 1С, Bonita BPM, CMIS, LDAP. Разработка приложения управления" +
                " окружением на стеке: Scala/Play/Anorm/JQuery. Разработка SSO аутентификации и" +
                " авторизации различных ERP модулей, интеграция CIFS/SMB java сервера.");
        list.add("Реализация c нуля Rich Internet Application приложения на стеке технологий JPA, Spring," +
                " Spring-MVC, GWT, ExtGWT (GXT), Commet, HTML5, Highstock для алгоритмического трейдинга.");
        list.add("Создание JavaEE фреймворка для отказоустойчивого взаимодействия слабо-связанных сервисов" +
                " (SOA-base архитектура, JAX-WS, JMS, AS Glassfish). Сбор статистики сервисов и" +
                " информации о состоянии через систему мониторинга Nagios. Реализация онлайн клиента" +
                " для администрирования и мониторинга системы по JMX (Jython/ Django).");
        list.add("Реализация протоколов по приему платежей всех основных платежных системы России" +
                " (Cyberplat, Eport, Chronopay, Сбербанк), Белоруcсии(Erip, Osmp) и Никарагуа.");
        return new ListSection(list);
    }

    private static ListSection getQualificationsSection() {
        List<String> list = new ArrayList<>();
        list.add("JEE AS: GlassFish (v2.1, v3), OC4J, JBoss, Tomcat, Jetty, WebLogic, WSO2");
        list.add("Version control: Subversion, Git, Mercury, ClearCase, Perforce");
        list.add("DB: PostgreSQL(наследование, pgplsql, PL/Python), Redis (Jedis), H2, Oracle, " +
                "MySQL, SQLite, MS SQL, HSQLDB");
        list.add("Languages: Java, Scala, Python/Jython/PL-Python, JavaScript, Groovy");
        list.add("XML/XSD/XSLT, SQL, C/C++, Unix shell scripts");
        list.add("Java Frameworks: Java 8 (Time API, Streams), Guava, Java Executor, MyBatis, Spring (MVC," +
                " Security, Data, Clouds, Boot), JPA (Hibernate, EclipseLink), Guice, GWT(SmartGWT, ExtGWT/GXT)," +
                " Vaadin, Jasperreports, Apache Commons, Eclipse SWT, JUnit, Selenium (htmlelements).");
        list.add("Python: Django.");
        list.add("JavaScript: jQuery, ExtJS, Bootstrap.js, underscore.js");
        list.add("Scala: SBT, Play2, Specs2, Anorm, Spray, Akka");
        list.add("Технологии: Servlet, JSP/JSTL, JAX-WS, REST, EJB, RMI, JMS, JavaMail, JAXB, StAX, SAX, DOM, XSLT," +
                " MDB, JMX, JDBC, JPA, JNDI, JAAS, SOAP, AJAX, Commet, HTML5, ESB, CMIS, BPMN2, LDAP, " +
                "OAuth1, OAuth2, JWT.");
        list.add("Инструменты: Maven + plugin development, Gradle, настройка Ngnix");
        list.add("администрирование Hudson/Jenkins, Ant + custom task, SoapUI, JPublisher, Flyway, Nagios, iReport," +
                " OpenCmis, Bonita, pgBouncer");
        list.add("Отличное знание и опыт применения концепций ООП, SOA, шаблонов проектрирования, " +
                "архитектурных шаблонов, UML, функционального программирования");
        list.add("Родной русский, английский \"upper intermediate\"");
        return new ListSection(list);
    }

    private static OrganizationSection getExperienceSection() {
        return new OrganizationSection(
                new Organization("Java Online Projects", "https://java.ru/JavaOnlineProjects",
                        new Period(DateUtil.of(2013, Month.OCTOBER), DateUtil.NOW,
                                "Автор проекта",
                                "Создание, организация и проведение Java онлайн проектов и стажировок.")),
                new Organization("Wrike", "https://java.ru/Wrike",
                        new Period(DateUtil.of(2014, Month.OCTOBER), DateUtil.of(2016, Month.JANUARY),
                                "Старший разработчик (backend)",
                                "Проектирование и разработка онлайн платформы управления проектами Wrike " +
                                        "(Java 8 API, Maven, Spring, MyBatis, Guava, Vaadin, PostgreSQL, Redis). " +
                                        "Двухфакторная аутентификация, авторизация по OAuth1, OAuth2, JWT SSO.")),
                new Organization("RIT Center", "https://java.ru/RITCenter",
                        new Period(DateUtil.of(2012, Month.MARCH), DateUtil.of(2014, Month.OCTOBER),
                                "Java архитектор",
                                "Организация процесса разработки системы ERP для разных окружений: " +
                                        "релизная политика, версионирование, ведение CI (Jenkins), миграция базы " +
                                        "(кастомизация Flyway), конфигурирование системы " +
                                        "(pgBoucer, Nginx), AAA via SSO. Архитектура БД и серверной части системы. " +
                                        "Разработка интергационных сервисов: " +
                                        "CMIS, BPMN2, 1C (WebServices), сервисов общего назначения " +
                                        "(почта, экспорт в pdf, doc, html). Интеграция Alfresco JLAN для online " +
                                        "редактирование из браузера документов MS Office. " +
                                        "Maven + plugin development, Ant, Apache Commons, Spring security, " +
                                        "Spring MVC, Tomcat,WSO2, xcmis, OpenCmis, Bonita, Python scripting, " +
                                        "Unix shell remote scripting via ssh tunnels, PL/Python")),
                new Organization("Luxoft (Deutsche Bank)", "https://java.ru/LuxoftDeutscheBank",
                        new Period(DateUtil.of(2010, Month.JANUARY), DateUtil.of(2012, Month.APRIL),
                                "Ведущий программист",
                                "Участие в проекте Deutsche Bank CRM (WebLogic, Hibernate, Spring, " +
                                        "Spring MVC, SmartGWT, GWT, Jasper, Oracle). Реализация клиентской и " +
                                        "серверной части CRM. Реализация RIA-приложения для администрирования, " +
                                        "мониторинга и анализа результатов в области алгоритмического трейдинга. " +
                                        "JPA, Spring, Spring-MVC, GWT, ExtGWT (GXT), Highstock, Commet, HTML5.")),
                new Organization("Yota", "https://java.ru/Yota",
                        new Period(DateUtil.of(2008, Month.JUNE), DateUtil.of(2010, Month.DECEMBER),
                                "Ведущий специалист",
                                "Дизайн и имплементация Java EE фреймворка для отдела " +
                                        "\"Платежные Системы\" (GlassFish v2.1, v3, OC4J, EJB3, JAX-WS RI 2.1, " +
                                        "Servlet 2.4, JSP, JMX, JMS, Maven2). " +
                                        "Реализация администрирования, статистики и мониторинга фреймворка. " +
                                        "Разработка online JMX клиента (Python/ Jython, Django, ExtJS)")),
                new Organization("Enkata", "https://java.ru/Enkata",
                        new Period(DateUtil.of(2007, Month.MARCH), DateUtil.of(2008, Month.JUNE),
                                "Разработчик ПО",
                                "Реализация клиентской (Eclipse RCP) и серверной (JBoss 4.2, Hibernate 3.0," +
                                        " Tomcat, JMS) частей кластерного J2EE приложения (OLAP, Data mining)")),
                new Organization("Siemens AG", "https://java.ru/SiemensAG",
                        new Period(DateUtil.of(2005, Month.JANUARY), DateUtil.of(2007, Month.FEBRUARY),
                                "Разработчик ПО",
                                "Разработка информационной модели, проектирование интерфейсов, реализация и" +
                                        " отладка ПО на мобильной IN платформе Siemens @vantage (Java, Unix).")),
                new Organization("Alcatel", "https://java.ru/Alcatel",
                        new Period(DateUtil.of(1997, Month.SEPTEMBER), DateUtil.of(2005, Month.JANUARY),
                                "Инженер по аппаратному и программному тестированию",
                                "Тестирование, отладка, внедрение ПО цифровой телефонной станции " +
                                        "Alcatel 1000 S12 (CHILL, ASM).")));
    }

    private static OrganizationSection getEducationSection() {
        return new OrganizationSection(
                new Organization("Coursera", "https://java.ru/Coursera",
                        new Period(DateUtil.of(2013, Month.OCTOBER), DateUtil.NOW,
                                "Martin Odersky",
                                "Functional Programming Principles in Scala' by Martin Odersky")),
                new Organization("Luxoft", "https://java.ru/Luxoft",
                        new Period(DateUtil.of(2011, Month.MARCH), DateUtil.of(2011, Month.APRIL),
                                "Объектно-ориентированный анализ ИС. Концептуальное моделирование на UML",
                                "Курс 'Объектно-ориентированный анализ ИС. " +
                                        "Концептуальное моделирование на UML.")),
                new Organization("Siemens AG", "https://java.ru/SiemensAG",
                        new Period(DateUtil.of(2005, Month.JANUARY), DateUtil.of(2005, Month.APRIL),
                                "Мобильные сети",
                                "3 месяца обучения мобильным IN сетям (Берлин)")),
                new Organization("Alcatel", "https://java.ru/Alcatel",
                        new Period(DateUtil.of(1997, Month.SEPTEMBER), DateUtil.of(1998, Month.MARCH),
                                "Цифровые телефонные сети",
                                "6 месяцев обучения цифровым телефонным сетям (Москва)")),
                new Organization("Санкт-Петербургский национальный исследовательский " +
                        "университет информационных технологий, механики и оптики\", \"java.ru/SUITMO",
                        "https://java.ru/SUITMO",
                        new Period(DateUtil.of(1993, Month.SEPTEMBER), DateUtil.of(1996, Month.JULY),
                                "Аспирантура (программист С, С++)",
                                ""),
                        new Period(DateUtil.of(1987, Month.SEPTEMBER), DateUtil.of(1993, Month.JULY),
                                "Инженер (программист Fortran, C)",
                                "")),
                new Organization("Заочная физико-техническая школа при МФТИ", "https://java.ru/MFTI",
                        new Period(DateUtil.of(1984, Month.SEPTEMBER), DateUtil.of(1987, Month.JUNE),
                                "Университет МФТИ",
                                "Закончил с отличием")));
    }
}
