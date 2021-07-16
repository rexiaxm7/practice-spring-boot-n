package com.example.management;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;
import org.apache.logging.log4j.MarkerManager;

@SpringBootApplication
public class ManagementApplication {

	public static void main(String[] args) {
		SpringApplication.run(ManagementApplication.class, args);
		
		//Log4j2でログ出力を行う
		 Logger logger = LogManager.getLogger(ManagementApplication.class);
		 logger.debug("これはDEBUG(デバッグ)のテスト用ログです");
		 logger.info("これはINFO(情報)のテスト用ログです");
		 logger.warn("これはWARN(警告)のテスト用ログです");
		 logger.error(MarkerManager.getMarker("ERROR"),"エラーメッセージ");
	}

}
