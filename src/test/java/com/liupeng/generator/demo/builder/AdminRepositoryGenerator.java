package com.liupeng.generator.demo.builder;

import java.util.List;

import org.junit.Before;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.test.context.ContextConfiguration;
import org.springframework.test.context.junit4.SpringRunner;

import com.joinway.yilian.generator.dao.AbstractRepositoryBuilder;
import com.joinway.yilian.generator.dao.bean.DBConfig;

@RunWith(SpringRunner.class)
@ContextConfiguration("classpath:spring/repository-generator-context.xml") 
public class AdminRepositoryGenerator extends AbstractRepositoryBuilder {

	private static final Logger log = LoggerFactory.getLogger(AdminRepositoryGenerator.class);
	
	@Override
	protected String getModuleName() {
		return "liup-admin";
	}

	@Override
	protected String getAdminRoot() {
		return "F:\\youqu\\liup_admin_code\\liup-admin-html\\app";
//		return "D:\\tmp\\yilian-admin-html";
	}

	@Before public void init(){
		moduleName = getModuleName();
		
		config = ConfigFactory.getConfig();
	}

	@Override
	protected String getJavaFileOutputFolder() {
		// 自定义输出路径
//		return "d:\\tmp";
		return super.getJavaFileOutputFolder();
	}
	
	@Test public void build() throws Exception {
		super.withUI = true;
//		buildSingleRepository();
		buildAllRepositories();
	}
	
	private void buildSingleRepository() throws Exception {
//		String[] tables = new String[]{"t_email_password_log", "t_dummy"};
		String[] tables = new String[]{"t_keyword_log"};
		generateStubs(tables);
	}
	
	private void buildAllRepositories() throws Exception {
		List<String> tableNames = getAllTableNames();
		generateStubs(tableNames.toArray(new String[0]));
	}

}
