package com.resumelibrary.utilities;

import org.apache.log4j.LogManager;
import org.apache.log4j.Logger;
import org.testng.Assert;

import java.lang.reflect.Field;

public class URLConstants implements Constants {

    private static final Logger logger = LogManager.getLogger(URLConstants.class);
    // ================> Client Constants Started <=========================
    public final String CLIENT_ACCOUNT_USERS_ADD = "/client/account/users/add";
    public final String CLIENT_ACCOUNT_USERS_EDIT = "/client/account/users/edit/";
    public final String CLIENT_CONTACT = "/client/contact";
    public final String CLIENT_HELP = "/client/help";
    public final String CLIENT_HELP_VIDEOS_INVITE_TO_APPLY = "/client/help/videos/invite-to-apply";
    public final String CLIENT_HELP_VIDEOS_SEARCH_BUILDER = "/client/help/videos/search-builder";
    public final String CLIENT_HELP_VIDEOS_VIDEO_INTERVIEWS = "/client/help/videos/video-interviews";
    public final String CLIENT_JOBS_NEW_JOB_POSTED = "/client/jobs/new_job_posted/";
    public final String CLIENT_RESUME_SEARCH_RESULTS = "/client/resume-search/results";
    public final String CLIENT_RESUME_VIEW_CANDIDATE_APPLICATION = "/client/resume/view-candidate-application/";
    public final String CLIENT_RESUME_VIEW_CANDIDATE_PROFILE = "/client/resume/view_candidate_profile/";
    public final String CLIENT_RESUME_VIEW_CANDIDATE_PROFILE3 = "/client/resume/view_candidate_profile/1629326/1/3fc3a8c24323";
    public final String CLIENT_RESUME_VIEW_CANDIDATE_PROFILE1 = "/client/resume/view_candidate_profile/11018283/1/0335c0ef22e5";
    public final String CLIENT_RESUME_VIEW_CANDIDATE_PROFILE2A = "/client/resume/view_candidate_profile/7900717";
    public final String CLIENT_RESUME_VIEW_CANDIDATE_PROFILE2 = "/client/resume/view_candidate_profile/7900717/1/ed6c0a015df6";
    public final String CLIENT_RESUME_VIEW_CANDIDATE_PROFILE_SEARCH = "/client/resume/view_candidate_profile/search/";
    public final String CLIENT_RESUME_ALERT_EDIT = "/client/resume_alert/edit/";
    public final String CLIENT_RESUME_ALERT_LOG = "/client/resume_alert/log";
    public final String CLIENT_RESUME_ALERTS = "/client/resume_alerts";
    public final String CLIENT_RESUME_ALERTS_1 = "/client/resume_alerts/1";
    public final String CLIENT_RESUME_ALERTS_2 = "/client/resume_alerts/2";
    public final String CLIENT_RESUME_ALERTS_LOG = "/client/resume_alerts/log";
    public final String DOWNLOADS_RL_USER_MANUAL = "/downloads/rl-user-manual";
    public final String DOWNLOADS_RL_USER_MANUAL_PDF = "/downloads/rl-user-manual.pdf";
    public final String LOGOUT = "/logout";
    public final String HIRING_PRODUCTS = "/hiring/products";
    public final String HIRING_REQUEST_A_DEMO = "/hiring/request-a-demo";
    public final String CLIENT_ACCOUNT = "/client/account";
    public final String FAQ_RECRUITER_EXTEND_POSTING = "/faq?type=recruiter#extend-posting";
    public final String CLIENT_JOB_APPLICATIONS = "/client/job/applications";
    public final String CLIENT_RESUME_ALERT_CREATE = "/client/resume_alert/create";
    public final String CLIENT_RESUME_ALERT = "/client/resume_alerts";
    public final String CLIENT_RESUME_ALERT_LOG_5202 = "/client/resume_alert/log/5202";
    public final String CLIENT_RESUME_ALERT_5202 = "/client/resume_alert/5202";
    public final String CLIENT_RESUME_ALERT_LOG_5202_2 = "/client/resume_alert/log/5202/2";
    public final String CLIENT_RESUME_ALERT_LOG_5202_1 = "/client/resume_alert/log/5202/1";
    public final String CLIENT_REGISTRATION = "/client/registration";
    public final String CLIENT_JOBS = "/client/jobs";
    public final String CLIENT_JOBS_1 = "/client/jobs/1";
    public final String CLIENT_JOBS_2 = "/client/jobs/2";
    public final String CLIENT_JOBS_INACTIVE_1 = "/client/jobs/inactive/1";
    public final String CLIENT_JOBS_INACTIVE_2 = "/client/jobs/inactive/2";
    public final String CLIENT_RESUME_SEARCH = "/client/resume-search";
    public final String CLIENT_RESUME_SEARCH_WITH_KEYWORD_USING_NO_QUOTES = "/client/resume-search/results?keywords=strange";
    public final String CLIENT_RESUME_SEARCH_WITH_KEYWORD_USING_DOUBLE_QUOTES = "/client/resume-search/results?keywords=%22strange%22";
    public final String CLIENT_RESUME_SEARCH_WITH_KEYWORD_USING_SINGLE_QUOTES = "/client/resume-search/results?keywords=%27test%27";
    public final String CLIENT_RESUME_SEARCH_WITH_KEYWORD_USING_SMART_QUOTES = "/client/resume-search/results?keywords=%E2%80%9Ctest%E2%80%9D";
    public final String CLIENT_RESUME_SEARCH_WITH_KEYWORD_USING_UNPAIRED_INITIAL_QUOTES = "/client/resume-search/results?keywords=%22test";
    public final String CLIENT_RESUME_SEARCH_WITH_KEYWORD_USING_UNPAIRED_TERMINAL_QUOTES = "/client/resume-search/results?keywords=test%22";
    public final String CLIENT_RESUME_SEARCH_WITH_KEYWORD_USING_LOWER_CASE = "/client/resume-search/results?keywords=test";
    public final String CLIENT_RESUME_SEARCH_WITH_KEYWORD_USING_UPPER_CASE = "/client/resume-search/results?keywords=TEST";
    public final String CLIENT_RESUME_SEARCH_WITH_KEYWORD_USING_MIXED_CASE = "/client/resume-search/results?keywords=tEsT";
    public final String CLIENT_RESUME_SEARCH_WITH_KEYWORDS = "/client/resume-search/results?keywords=sales+OR+php+OR+test&submt_btn=1";
    public final String CLIENT_RESUME_SEARCH_WITH_SALES_KEYWORDS = "/client/resume-search/results?keywords=sales";
    public final String CLIENT_RESUME_SEARCH_WITH_UNQUOTED_KEYWORDS = "/client/resume-search/results?keywords=strange+test";
    public final String CLIENT_RESUME_SEARCH_WITH_QUOTED_KEYWORDS = "/client/resume-search/results?keywords=%22strange+test%22";
    public final String CLIENT_RESUME_SEARCH_WITH_UNQUOTED_KEYWORD = "/client/resume-search/results?keywords=strange";
    public final String CLIENT_RESUME_SEARCH_WITH_QUOTED_KEYWORD = "/client/resume-search/results?keywords=%22strange%22";
    public final String CLIENT_RESUME_SEARCH_WITH_KEYWORDS_USING_NO_QUOTES = "/client/resume-search/results?keywords=strange+test";
    public final String CLIENT_RESUME_SEARCH_WITH_KEYWORDS_USING_DOUBLE_QUOTES = "/client/resume-search/results?keywords=%22strange+test%22";
    public final String CLIENT_RESUME_SEARCH_WITH_KEYWORDS_USING_SINGLE_QUOTES = "/client/resume-search/results?keywords=%27strange+test%27";
    public final String CLIENT_RESUME_SEARCH_WITH_KEYWORDS_USING_SMART_QUOTES = "/client/resume-search/results?keywords=%E2%80%9Cstrange+test%E2%80%9D";
    public final String CLIENT_RESUME_SEARCH_WITH_KEYWORDS_USING_UNPAIRED_INITIAL_QUOTES = "/client/resume-search/results?keywords=%22strange+test";
    public final String CLIENT_RESUME_SEARCH_WITH_KEYWORDS_USING_UNPAIRED_TERMINAL_QUOTES = "/client/resume-search/results?keywords=strange+test%22";
    public final String CLIENT_RESUME_SEARCH_WITH_KEYWORDS_USING_AND = "/client/resume-search/results?keywords=strange+and+test";
    public final String CLIENT_RESUME_SEARCH_WITH_KEYWORDS_USING_AMPERSAND = "/client/resume-search/results?keywords=strange+%26+test";
    public final String CLIENT_RESUME_SEARCH_WITH_KEYWORDS_USING_DOUBLE_AMPERSAND = "/client/resume-search/results?keywords=strange+%26%26+test";
    public final String CLIENT_RESUME_SEARCH_WITH_KEYWORDS_USING_SPACED_DOT = "/client/resume-search/results?keywords=strange+.+test";
    public final String CLIENT_RESUME_SEARCH_WITH_KEYWORDS_USING_UNSPACED_DOT = "/client/resume-search/results?keywords=strange.test";
    public final String CLIENT_RESUME_SEARCH_WITH_KEYWORDS_USING_PLUS = "/client/resume-search/results?keywords=strange%2Btest";
    public final String CLIENT_RESUME_SEARCH_WITH_KEYWORDS_USING_OR = "/client/resume-search/results?keywords=strange+or+test";
    public final String CLIENT_RESUME_SEARCH_WITH_KEYWORDS_USING_COMMA = "/client/resume-search/results?keywords=strange+%2C+test";
    public final String CLIENT_RESUME_SEARCH_WITH_KEYWORDS_USING_VERTICAL_BAR = "/client/resume-search/results?keywords=strange+%7C+test";
    public final String CLIENT_RESUME_SEARCH_WITH_KEYWORDS_USING_NOT = "/client/resume-search/results?keywords=strange+not+test";
    public final String CLIENT_RESUME_SEARCH_WITH_KEYWORDS_USING_GT_LT = "/client/resume-search/results?keywords=strange+%3c%3E+test";
    public final String CLIENT_RESUME_SEARCH_WITH_KEYWORDS_USING_NOT_EQUAL = "/client/resume-search/results?keywords=strange+%21%3D+test";
    public final String CLIENT_RESUME_SEARCH_WITH_KEYWORDS_USING_PARENTHESIS_FIRST = "/client/resume-search/results?keywords=%28+testers+and+sales+%29+or+recruit";
    public final String CLIENT_RESUME_SEARCH_WITH_KEYWORDS_USING_PARENTHESIS_LAST = "/client/resume-search/results?keywords=testers+and+%28+sales+or+recruit+%29";
    public final String CLIENT_RESUME_SEARCH_WITH_KEYWORDS_USING_PARENTHESIS_TWICE = "/client/resume-search/results?keywords=%28testers+OR+something%29+AND+%28sales+AND+recruit%29";
    public final String CLIENT_RESUME_SEARCH_WITH_KEYWORDS_USING_SQUARE_BRACKETS = "/client/resume-search/results?keywords=testers+and+%5Bsales+or+recruit%5D";
    public final String CLIENT_RESUME_SEARCH_WITH_KEYWORDS_USING_CURLY_BRACKETS = "/client/resume-search/results?keywords=testers+AND+%7B+sales+OR+recruit+%7D";
    public final String CLIENT_RESUME_SEARCH_WITH_KEYWORDS_LOCATION = "/client/resume-search/results?search_builder=1&keywords=sales+manager&location=10001&distance=35+&updated_on=3+months&submt_btn=1";

    public final String HIRING = "/hiring";
    public final String RESOURCES = "/resources/";
    public final String CLIENT_PURCHASE = "/client/purchase";
    public final String CLIENT_PURCHASE_HISTORY_2 = "/client/purchase-history/2?";
    public final String CLIENT_PRODUCTS_CONTACT_CREDITS = "/client/products/contact-credits";
    public final String CLIENT_HELP_JOB_POSTING = "/client/help/job-posting";
    public final String CLIENT_HELP_ALERT_TIPS = "/client/help/alert-tips";
    public final String HIRING_RESUME_SEARCH = "/hiring/resume-search";
    public final String CLIENT_JOBS_INACTIVE = "/client/jobs/inactive";
    public final String CLIENT_JOBS_TEMPLATES = "/client/jobs/templates";
    public final String JOB_POST = "/job/post";
    public final String HIRING_POST_JOBS = "/hiring/post-jobs";
    public final String CLIENT_HELP_VACANCY_ENHANCEMENTS = "/client/help/vacancy-enhancements";
    public final String HIRING_LOGIN = "/hiring/login";
    public final String CLIENT_ACCOUNT_USERS = "/client/account/users";
    public final String CLIENT_DEMOGRAPHICS = "/hiring/demographics";
    public final String CLIENT_HELP_VIDEOS = "/client/help/videos";
    public final String CLIENT_ACCOUNT_INTEGRATED_SERVICES = "/client/account/integrated-services";
    public final String CLIENT_LATEST_FEATURES = "/client/latest-features";
    public final String CLIENT_MY_UNLOCKED_RESUMES = "/client/my-unlocked-resumes";
    public final String CLIENT_MY_UNLOCKED_RESUMES_20 = "/client/my-unlocked-resumes/20";
    public final String CLIENT_MY_UNLOCKED_RESUMES_0 = "/client/my-unlocked-resumes/0";
    public final String HIRING_PAY_FOR_PERFORMANCE_JOB_ADVERTISING = "/hiring/pay-for-performance-job-advertising";
    public final String CLIENT_PRODUCTS_JOBS = "/client/products/jobs";
    public final String CLIENT_PURCHASE_HISTORY = "/client/purchase-history";
    public final String CLIENT_SAVED_SEARCH = "/client/saved-search";
    public final String CLIENT_SAVED_SEARCH_ACCOUNT = "/client/saved-search/account";
    public final String CLIENT_ACCOUNT_SAVED_RESUMES = "/client/account-saved-resumes";
    public final String CLIENT_ACCOUNT_SAVED_RESUMES_20 = "/client/account-saved-resumes/20";
    public final String CLIENT_ACCOUNT_SAVED_RESUMES_0 = "/client/account-saved-resumes/0";
    public final String CLIENT_ACCOUNT_UNLOCKED_RESUMES = "/client/account-unlocked-resumes";
    public final String CLIENT_ACCOUNT_UNLOCKED_RESUMES_20 = "/client/account-unlocked-resumes/20";
    public final String CLIENT_ACCOUNT_UNLOCKED_RESUMES_0 = "/client/account-unlocked-resumes/0";
    public final String CLIENT_MY_SAVED_RESUMES = "/client/my-saved-resumes";
    public final String CLIENT_MY_SAVED_RESUMES_20 = "/client/my-saved-resumes/20";
    public final String CLIENT_MY_SAVED_RESUMES_0 = "/client/my-saved-resumes/0";
    public final String USER_CHANGE_PASSWORD = "/user/change-password";
    public final String CLIENT_EMAIL_PREFERENCES = "/client/email-preferences";
    public final String CLIENT_HELP_SEARCH_TIPS = "/client/help/search-tips";
    public final String HIRING_DEMOGRAPHICS = "/hiring/demographics";
    public final String CLIENT_HELP_VIDEOS_SCREENING_QUESTIONS = "/client/help/videos/screening-questions";
    public final String CLIENT_COMPANY_PROFILE = "/client/company/profile";
    public final String HIRING_REQUEST_A_TRIAL = "/hiring/request-a-trial";
    public final String RESUME_OVERSIZED = "resume-oversized.odt";
    public final String RESUME_UNDERSIZED_TEXT_FILE = "resume-undersized.txt";
    public final String HIRING_RESUME_SEARCH_PRICING = "/hiring/resume-search/pricing";
    public final String HIRING_RESUME_SEARCH_TEST_SEARCH = "/hiring/resume-search/test-search";
    public final String PARTNER_INTEGRATIONS_ZOHO = "/partner/integrations/zoho";
    public final String RESOURCES_A_GUIDE_TO_VISAS_AND_WORK_PERMITS_FOR_FOREIGN_NATIONALS = "/resources/a-guide-to-visas-and-work-permits-for-foreign-nationals/";
    public final String RESOURCES_EVENTS = "/resources/events/";
    public final String CLIENT_PURCHASE_PAY_NOW = "/client/purchase/pay-now";
    public final String CLIENT_PURCHASE_AUTH = "/client/purchase/auth/";
    public final String CLIENT_PURCHASE_HISTORY_VIEW = "/client/purchase-history/view/";
    public final String HIRING_PARTNER_NETWORK = "/hiring/partner-network";
    public final String HIRING_REQUEST_A_TRAIL = "/hiring/request-a-trial";
    public final String RESOURCES_ATTRACTING_CANDIDATES = "/resources/attracting-candidates/";
    public final String RESOURCES_INTERVIEW_TIPS = "/resources/interviewing-tips";
    public final String RESOURCES_JOB_MARKET_INSIGHTS = "/resources/job-market-insights";
    public final String RESOURCES_MAKING_HIRE = "/resources/making-the-hire";
    public final String RESOURCES_WORKPLACE = "/resources/workplace";
    public final String RESOURCES_NEWS = "/resources/news";
    public final String RESOURCES_COVID_19_ADVICE = "/resources/covid-19-advice";
    public final String PARTNER_INTEGRATIONS_BROADBEAN = "/partner/integrations/broadbean";
    public final String PARTNER_INTEGRATIONS_ATS = "/partner/integrations/ats";
    public final String CLIENT_RESUME_ALERT_MSG_CREATED = "/client/resume_alerts/?msg=created";
    public final String FAQ_RECRUITER_EDIT_ACCOUNT = "/faq?type=recruiter#edit-account";
    public final String FAQ_RECRUITER_VALIDATE_ACCOUNT = "/faq?type=recruiter#validate-account";
    public final String FAQ_RECRUITER_VALIDATE_EXTEND_POSTING = "/faq?type=recruiter#extend-posting";
    public final String FAQ_RECRUITER_RESUME_SEARCH = "/faq?type=recruiter#resume-search";
    public final String FAQ_RECRUITER_JOB_LENGTH = "/faq?type=recruiter#job-length";
    public final String FAQ_RECRUITER = "/faq?type=recruiter";
    public final String CLIENT_RESUME_ALERTS_MSG_CREATED = "/client/resume_alerts/?msg=created";
    public final String CLIENT_RESUME_ALERTS_MSG_SAVED = "/client/resume_alerts/?msg=saved";
    public final String RESOURCES_LATEST = "/resources/latest/";
    public final String RESOURCES_MAKING_THE_HIRE = "/resources/making-the-hire";
    // ================> Client Constants Ended <=========================

    // ================> Candidate Constants Started <=========================
    public final String JOBS_SALES_IN_10001 = "/jobs/sales-in-10001";
    public final String JOBS_SALES_IN_10001_RESULTS = "/jobs/sales-in-10001?pd=15&r=20&annual_salary_from=50000&annual_salary_to=70000&job_type=Permanent";
    public final String SEARCH_JOBS_ON_THE_GO = "/search-jobs-on-the-go";
    public final String CANDIDATE_MYAPPLICATIONS_VIEWAPPLICATION = "/candidate/myapplications/viewapplication/";
    public final String JOB_APPLY = "/job/apply";
    public final String JOB_APPLY_CONFIRM = "/job/apply/confirm/";
    public final String JOB_EDIT = "/job/edit/";
    public final String JOB_VIEW = "/job/view/";
    public final String JOBS_ACCOUNTING = "/jobs/accounting";
    public final String JOBS_ADMINISTRATIVE_ASSISTANCE = "/jobs/administrative-assistance";
    public final String JOBS_AUTOMATION = "/jobs/automation";
    public final String JOBS_IN_ALABAMA_AL_STATE = "/jobs/in-alabama-al-state";
    public final String LOGIN_APPLY = "/login/apply/";
    public final String JOBS_IN_ARLINGTON_TX = "/jobs/in-arlington-tx";
    public final String JOBS_IN_BOSSIER_CITY_LA = "/jobs/in-bossier-city-la";
    public final String JOBS_IN_BOSTON_MA = "/jobs/in-boston-ma";
    public final String JOBS_SALES_PAGE_2= "/jobs/sales?page_number=2";
    public final String JOBS_SALES_PP75_PAGE_2= "/jobs/sales?pp=75&page_number=2";
    public final String JOBS_SALES_PP75 = "/jobs/sales?pp=75";
    public final String JOBS_IN_HUNTSVILLE_AL = "/jobs/in-huntsville-al";
    public final String JOBS_SALES_IN_NEW_YORK_CITY_NY = "/jobs/sales-in-new-york-city-ny";
    public final String JOBS_SALES_IN_BROOKLYN_NY = "/jobs/sales-in-brooklyn-ny";
    public final String JOBS_IN_NEW_YORK_CITY_NY="/jobs/in-new-york-city-ny";
    public final String MEET_THE_TEAM = "/meet-the-team";
    public final String PRIVACY = "/privacy";
    public final String REGISTER_APPLY = "/register/apply/";
    public final String SEARCH_JOBS_LOCATIONS_ALABAMA = "/search-jobs/locations/alabama";
    public final String TERMS = "/terms";
    public final String USER_RESET_PASSWORD = "/user/reset-password";
    public final String ABOUT = "/about";
    public final String ACCOUNT_VIEW = "/account/view/";
    public final String CANDIDATE_HIDE = "/candidate/hide";
    public final String CAREER_ADVICE_RESUME_TIPS = "/career-advice/resume-tips/";
    public final String CAREER_ADVICE_COVER_LETTERS = "/career-advice/cover-letters/";
    public final String CAREER_ADVICE_INTERVIEWS = "/career-advice/interviews/";
    public final String CAREER_ADVICE_AT_WORK = "/career-advice/at-work/";
    public final String CAREER_ADVICE_CAREER_DEVELOPMENT = "/career-advice/career-development/";
    public final String CAREER_ADVICE_LOCATION_GUIDES = "/career-advice/location-guides/";
    public final String CAREER_ADVICE_GRADES = "/career-advice/grads/";
    public final String CAREER_ADVICE_GIG_JOBS = "/career-advice/gig-jobs/";
    public final String CAREER_ADVICE_COVID_19_ADVICE = "/career-advice/covid-19-advice/";
    public final String CAREER_ADVICE_COVID_GETTING_STARTED = "/career-advice/getting-started/";
    public final String COMPANIES_BROWSE = "/companies/browse";
    public final String JOBS_ADMINISTRATIVE_ASSISTANT = "/jobs/administrative-assistant";
    public final String CANDIDATE_RESUME_REVIEW_SUCCESS = "/candidate/resume-review-success";
    public final String TEST_CV = "/test-cv.pdf";
    public final String CANDIDATE_REGISTRATION_CONFIRM = "/candidate/registration/confirm";
    public final String CANDIDATE_DELETE = "/candidate/delete";
    public final String CANDIDATE_DELETE_CONFIRM = "/candidate/delete/confirm";
    public final String JOBS_IN_10001 = "/jobs/in-10001";
    public final String JOBS_IN_10002 = "/jobs/in-10002";
    public final String CANDIDATE_ACCOUNT = "/candidate/account";
    public final String CANDIDATE_MY_PROFILE = "/candidate/my-profile";
    public final String CANDIDATE_MY_DASHBOARD = "/candidate/my-dashboard";
    public final String CANDIDATE_REGISTRATION = "/candidate/registration";
    public final String CANDIDATE_MYAPPLICATIONS = "/candidate/myapplications";
    public final String JOBS_NON_EXTERNAL_TEST_JOBS = "/jobs/nonexternaltestjob?pd=1";
    public final String CANDIDATE_SETTINGS = "/candidate/settings";
    public final String CAREER_ADVICE = "/career-advice/";
    public final String CAREER_ADVICE_GETTING_STARTED = "/career-advice/getting-started/";
    public final String JOBS_SALES = "/jobs/sales";
    public final String JOBS_NONEXTERNALTESTJOBS = "/jobs/nonexternaltestjobs";
    public final String COMPANIES = "/companies";
    public final String COMPANIES_ACME_COMPANY_1728 = "/companies/acme-company-1728";
    public final String COMPANY = "/company";
    public final String CONTACT = "/contact";
    public final String FAQ = "/faq";
    public final String CANDIDATE_COVER_LETTER = "/candidate/cover-letter";
    public final String JOBS_SALES_IN_HOUSTON = "/jobs/sales-in-houston-tx";
    public final String CANDIDATE_JOB_ALERTS = "/candidate/job-alerts";
    public final String CAREER_ADVICE_GRADS = "/career-advice/grads/";
    public final String JOB_ALERTS = "/job-alerts";
    public final String JOBS_APPLY_CONFIRM = "/job/apply/confirm/28323500/5964614";
    public final String JOBS_ONE_CLICK_APPLY = "/jobs/1-click-apply-in-90001?pd=1&annual_salary_from=10000&annual_salary_to=30000";
    public final String JOBS_SCREENING_QUESTIONS = "/jobs/screening-questions-in-90001?pd=1&annual_salary_from=10000&annual_salary_to=30000";
    public final String JOBS_ONE_CLICK_APPLY_CANDIDATE_JOB = "/jobs/quick-apply-candidate-job-in-90001?pd=1&annual_salary_from=10000&annual_salary_to=30000";
    public final String SEARCH_JOBS_LOCATIONS = "/search-jobs/locations";
    public final String SEARCH_JOBS_LOCATIONS_IN_ALABAMA = "/search-jobs/locations/alabama";
    public final String JOBS = "/jobs";
    public final String JOBS_SALES_IN_NEW_YORK = "/jobs/sales-in-new-york-city-ny";
    public final String SEARCH_JOBS = "/search-jobs";
    public final String JOBS_WEB_JOB = "/jobs/web-job-in-90001?pd=1";
    public final String JOBS_AMAZON = "/jobs/amazon";
    public final String JOBS_QA = "/jobs/qa";
    public final String JOBS_SPLELING = "/jobs/spleling";
    public final String JOBS_XXYY = "/jobs/xxyy";
    public final String JOBS_PREMIUM_FEATURED = "/jobs/premium-featured-job";
    public final String JOBS_IN_FLORIDA = "/jobs/in-florida-fl-state";
    public final String JOBS_TEST = "/jobs/test";
    public final String JOBS_QA_TESTER = "/jobs/qa-tester-in-10010";
    public final String JOBS_VIEW_FOR_3509582 = "/job/view/3509582";
    public final String JOB_AUTOMATION = "/jobs/automation";
    public final String JOBS_TESTER = "/jobs/tester";
    public final String JOBS_DRUMMER = "/jobs/drummer-in-90001";
    public final String JOB_VIEW_FOR_25759485 = "/job/view/25759485";
    public final String JOB_VIEW_ABC = "/job/view/abc";
    public final String JOB_VIEW_FOR_11740 = "/job/view/11740";
    public final String JOB_VIEW_12572172 = "/job/view/12572172";
    public final String JOB_VIEW_SALES_LEAD_FOR_37890455 = "/job/view/37890455/sales-lead";
    public final String JOB_VIEW_FOR_24146400 = "/job/view/24146400";
    public final String JOBS_SALES_IN_BROOKLYN_NY_R_250_ANNUAL_SALARY_FROM_50000_ANNUAL_SALARY_TO_100000 ="/jobs/sales-in-brooklyn-ny?r=250&annual_salary_from=50000&annual_salary_to=100000";
    public final String JOBS_SALES_IN_BROOKLYN_NY_R_250_ANNUAL_SALARY_FROM_50000_ANNUAL_SALARY_TO_100000_PAGE_NUMBER_2 ="/jobs/sales-in-brooklyn-ny?r=250&annual_salary_from=50000&annual_salary_to=100000&page_number=2";
    public final String JOBS_SALES_IN_BROOKLYN_NY_R_250_ANNUAL_SALARY_FROM_50000_ANNUAL_SALARY_TO_100000_PAGE_NUMBER_3 ="/jobs/sales-in-brooklyn-ny?r=250&annual_salary_from=50000&annual_salary_to=100000&page_number=3";
    public final String JOBS_SALES_IN_NEW_YORK_CITY_NY_PD_15_ANNUAL_SALARY_FROM_50000_ANNUAL_SALARY_TO_70000_JOB_TYPE_PERMANENT ="/jobs/sales-in-new-york-city-ny?pd=15&annual_salary_from=50000&annual_salary_to=70000&job_type=Permanent";
    public final String JOBS_WEB_JOB_IN_90001_PD_1_PAGE_NUMBER_2_PN_20 ="/jobs/web-job-in-90001?pd=1&page_number=2&pn=20";
    public final String JOBS_WEB_JOB_IN_90001_PD_1 ="/jobs/web-job-in-90001?pd=1";
    public final String JOBS_SALES_IN_BROOKLYN_NY_PAGE_NUMBER_2 ="/jobs/sales-in-brooklyn-ny?page_number=2";
    public final String JOBS_NONEXTERNALTESTJOB_IN_90189_R_51 ="/jobs/nonexternaltestjob-in-90189?r=51";
    public final String JOBS_SALES_IN_10010 = "/jobs/sales-in-10010";
    public final String JOBS_WEB_DEVELOPER = "/jobs/web-developer";
    public final String LOGIN = "/login";
    public final String RESUME_REVIEW = "/resume-review";
    public final String CANDIDATE_REGISTRATION_FOR_COUNTRY_CODE_GB = "/candidate/registration?country_id=GB";
    public final String CANDIDATE_SAVED_JOBS = "/candidate/saved-jobs";
    public final String CANDIDATE_EMAIL_PREFERENCES = "/candidate/email-preferences";
    public final String SAVED_JOBS = "/saved-jobs";
    public final String SEARCH_JOBS_PER_PAGE_20_MAX_PAGE_50 = "/jobs?page_number=50";
    public final String SEARCH_JOBS_PER_PAGE_75_MAX_PAGE_14 = "/jobs?pp=75&page_number=14";

    public final String SEARCH_JOBS_PER_PAGE_250_PAGE_NUMBER_5 = "/jobs?pp=250&page_number=5";
    public final String SEARCH_JOBS_PER_PAGE_250_PAGE_NUMBER_4 = "/jobs?pp=250&page_number=4";
    public final String SEARCH_JOBS_PER_PAGE_100_PAGE_NUMBER_10 = "/jobs?pp=100&page_number=10";
    public final String SEARCH_JOBS_PER_PAGE_100_PAGE_NUMBER_11 = "/jobs?pp=100&page_number=11";
    public final String SEARCH_JOBS_PER_PAGE_75_PAGE_NUMBER_14 = "/jobs?pp=75&page_number=14";
    public final String SEARCH_JOBS_PER_PAGE_75_PAGE_NUMBER_15 = "/jobs?pp=75&page_number=15";
    public final String SEARCH_JOBS_IN_TEXAS_TX_STATE_PAGE_NUMBER_51 = "/jobs/in-texas-tx-state?page_number=51";
    public final String SEARCH_JOBS_IN_TEXAS_TX_STATE_PAGE_NUMBER_50 = "/jobs/in-texas-tx-state?page_number=50";
    public final String SEARCH_JOBS_DRUMMER_IN_HOUSTON_TX_PER_PAGE_75_PAGE_NUMBER_14_PN_1113 = "/jobs/drummer-in-houston-tx?pp=75&page_number=14&pn=1113";
    public final String SEARCH_JOBS_DRUMMER_IN_HOUSTON_TX_PER_PAGE_75_PAGE_NUMBER_15_PN_1113 = "/jobs/drummer-in-houston-tx?pp=75&page_number=15&pn=1113";
    public final String SEARCH_JOBS_DRUMMER_IN_HOUSTON_TX_PER_PAGE_100_PAGE_NUMBER_11_PN_1050 ="/jobs/drummer-in-houston-tx?pp=100&page_number=11&pn=1050";
    public final String SEARCH_JOBS_DRUMMER_IN_HOUSTON_TX_PER_PAGE_100_PAGE_NUMBER_10_PN_1050 ="/jobs/drummer-in-houston-tx?pp=100&page_number=10&pn=1050";
    public final String SEARCH_JOBS_DRUMMER_IN_HOUSTON_TX_PER_PAGE_250_PAGE_NUMBER_4_PN_1118 ="/jobs/drummer-in-houston-tx?pp=250&page_number=4&pn=1118";
    public final String SEARCH_JOBS_DRUMMER_IN_HOUSTON_TX_PER_PAGE_250_PAGE_NUMBER_5_PN_1118 ="/jobs/drummer-in-houston-tx?pp=250&page_number=5&pn=1118";
    public final String SEARCH_JOBS_DRUMMER_IN_HOUSTON_TX ="/jobs/drummer-in-houston-tx";
    public final String SEARCH_JOBS_DRUMMER_IN_HOUSTON_TX_PER_PAGE_50 ="/jobs/drummer-in-houston-tx?pp=50";
    public final String SEARCH_JOBS_DRUMMER_IN_HOUSTON_TX_PER_PAGE_75 ="/jobs/drummer-in-houston-tx?pp=75";
    public final String SEARCH_JOBS_DRUMMER_IN_HOUSTON_TX_PER_PAGE_100 ="/jobs/drummer-in-houston-tx?pp=100";
    public final String SEARCH_JOBS_DRUMMER_IN_HOUSTON_TX_PER_PAGE_250 ="/jobs/drummer-in-houston-tx?pp=250";
    public final String SEARCH_JOBS_SALES_IN_NEW_YORK_CITY_NY_PER_PAGE_50 ="/jobs/sales-in-new-york-city-ny?pp=50";
    public final String SEARCH_JOBS_SALES_IN_NEW_YORK_CITY_NY_PER_PAGE_75 ="/jobs/sales-in-new-york-city-ny?pp=75";
    public final String SEARCH_JOBS_SALES_IN_NEW_YORK_CITY_NY_PER_PAGE_100 ="/jobs/sales-in-new-york-city-ny?pp=100";

    // ================> Candidate Constants Ended <=========================

    // ================> Admin Constants Started <=========================
    public final String CLIENT_SIGNUP = "/client/signup?t=u7wb66pp4FDoaxoR1CreKcT7IHSv2712dhW0AnGcrd4rt7JVFRXDXSjfIQ90kTXyjc3Xr4yhNBbOMBVC6NEkmcgDFn1UP3fiL7pp819WneRcEPPP3zSmlQFmaegCpIC97Yxm6l0rx0jsyC_PSwU7eCaOCxowXZQ6ynDQIsyn42M";
    public final String ACCOUNT_ACCOUNTLIST = "/account/accountlist";
    public final String ACCOUNT_1478 = "/account/view/1478";
    public final String ACCOUNT_11626 = "/account/view/11626";
    public final String ACCOUNT_19088 = "/account/view/19088";
    public final String JOBS_EDIT_24746408 = "/jobs/edit/24746408";
    public final String JOBS_EDIT_25759485 = "/jobs/edit/25759485";
    public final String ACCOUNT_PURCHASE_PRODUCTS_1478 = "/account/purchase_products/1478";
    public final String ACCOUNT_ADD = "/account/add";
    public final String ACCOUNT_ACCOUNTLIST_VERIFIED = "/account/accountlist/verified";
    public final String HIRING_VIDEO_GUIDES = "/hiring/video-guides";
    public final String RESOURCES_INTERVIEWING_TIPS = "/resources/interviewing-tips";
    public final String CLIENT_RESUME_VIEW_CANDIDATE_APPLICATIONS = "/client/resume/view-candidate-application/";
    public final String CANDIDATE_APPLICATIONS = "/candidate/applications";
    public final String PROJECT_STRUCTURE_IMAGE = "project_structure.jpg";
    public final String INDEX_HTML = "Index.html";
    public final String CLIENT_RESUME_SEARCH_UPDATE = "/client/resume-search/update";
    public final String JOBS_ADD = "/jobs/add";

    // ================> Admin Constants Ended <=========================

    // ================> Partner and Misc Constants Started <=========================
    public final String PARTNER_INTEGRATIONS = "/partner/integrations";
    public final String ADS = "/ads.txt";
    public final String PAGE_500_ERROR = "/500.html";
    public final String PAGE_403_ERROR = "/403.html";
    public final String PAGE_MAINTENANCE = "/maintenance.html";
    public final String ROBOTS = "/robots.txt";
    public final String SITE_MAP = "/sitemap";
    // ================> Partner and Misc Constants Ended <=========================

    public String getConstantsURL(String URL) {
        String returnURL = "";
        logger.info("browser url is : "  + URL);
        try {
            Field field = this.getClass().getDeclaredField(URL);
            field.setAccessible(true);
            returnURL = field.get(this).toString();
            logger.info("returned url from constants is : "  + returnURL);
        } catch (Exception e) {
            Assert.fail("failed while trying to get url from URL constants " + e.getMessage());
        }
        return returnURL;
    }
}