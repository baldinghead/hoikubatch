package jp.co.casleyconsulting.www.nurseryVacancy.test;

import static org.junit.Assert.*;

import java.util.List;

import jp.co.casleyconsulting.www.nurseryVacancy.constants.ExtractType;
import jp.co.casleyconsulting.www.nurseryVacancy.dto.NurseryInfo;
import jp.co.casleyconsulting.www.nurseryVacancy.dto.NurseryVacancyInfo;
import jp.co.casleyconsulting.www.nurseryVacancy.factory.InfoExtractorFactory;
import jp.co.casleyconsulting.www.nurseryVacancy.factory.VacancyExtractorFactory;

import org.junit.BeforeClass;
import org.junit.Test;

/**
 * 保育園情報抜き出し系
 *
 * @author yoshio
 *
 */
public class InfoExtractionTest {

	@BeforeClass
	public static void setup() {

		System.setProperty("proxySet", "true");
		System.setProperty("proxyHost", "10.221.237.10"); // プロキシサーバ
		System.setProperty("proxyPort", "8080"); // ポート番号

	}

	/**
	 * 中野区用
	 */
	@Test
	public void testMinato() {

		List<NurseryInfo> extracted = InfoExtractorFactory
						.create(ExtractType.NAKANO)
						.extract("http://www.city.tokyo-nakano.lg.jp/dept/244000/d011915.html");

		for (NurseryInfo info : extracted) {
			System.out.println(info.name);
		}
	}

}
