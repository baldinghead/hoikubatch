import java.util.List;

import jp.co.casleyconsulting.www.nurseryVacancy.constants.ExtractType;
import jp.co.casleyconsulting.www.nurseryVacancy.dto.NurseryVacancyInfo;
import jp.co.casleyconsulting.www.nurseryVacancy.factory.ExtractorFactory;

public class SoupTest {

	public static void main(String[] args) {

		System.setProperty("proxySet", "true");
		System.setProperty("proxyHost", "10.221.237.10"); // プロキシサーバ
		System.setProperty("proxyPort", "8080"); // ポート番号

		List<NurseryVacancyInfo> extracted = ExtractorFactory.create(
				ExtractType.TOSHIMA).extract(
				"https://www.city.toshima.lg.jp/kodomo/hoikuen/004481.html");

		System.out.print("hogege");

	}
}
