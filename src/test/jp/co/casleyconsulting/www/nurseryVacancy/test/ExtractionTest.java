package jp.co.casleyconsulting.www.nurseryVacancy.test;

import static org.junit.Assert.*;

import java.util.List;

import jp.co.casleyconsulting.www.nurseryVacancy.constants.ExtractType;
import jp.co.casleyconsulting.www.nurseryVacancy.dto.NurseryVacancyInfo;
import jp.co.casleyconsulting.www.nurseryVacancy.factory.ExtractorFactory;

import org.junit.BeforeClass;
import org.junit.Test;

public class ExtractionTest {

	@BeforeClass
	public static void setup() {

		System.setProperty("proxySet", "true");
		System.setProperty("proxyHost", "10.221.237.10"); // プロキシサーバ
		System.setProperty("proxyPort", "8080"); // ポート番号

	}

	/**
	 * 港区用
	 */
	@Test
	public void testMinato() {

		List<NurseryVacancyInfo> extracted = ExtractorFactory
						.create(ExtractType.MINATO)
						.extract("http://www.city.minato.tokyo.jp/kodomo/kodomo/kodomo/hoikuen/aki.html");

		for (NurseryVacancyInfo info : extracted) {
			System.out.println(info.name);
		}
	}

	/**
	 * 目黒区用
	 */
	@Test
	public void testMeguro() {

		List<NurseryVacancyInfo> extracted = ExtractorFactory
						.create(ExtractType.MEGURO)
						.extract("http://www.city.meguro.tokyo.jp/kurashi/kosodate/hoikuen/akijokyo.html");

		for (NurseryVacancyInfo info : extracted) {
			System.out.println(info.name);
		}
	}

}
