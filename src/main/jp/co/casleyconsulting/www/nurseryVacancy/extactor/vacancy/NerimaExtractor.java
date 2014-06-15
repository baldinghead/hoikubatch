package jp.co.casleyconsulting.www.nurseryVacancy.extactor.vacancy;

import java.util.ArrayList;
import java.util.List;

import jp.co.casleyconsulting.www.nurseryVacancy.dto.NurseryVacancyInfo;

import org.apache.commons.lang3.StringUtils;
import org.jsoup.nodes.Document;
import org.jsoup.nodes.Element;
import org.jsoup.select.Elements;

/**
 * 練馬区用Extractor
 *
 * @author FUJIWARA
 *
 */
public class NerimaExtractor extends GeneralExtractor {

	/*
	 * (非 Javadoc)
	 * 
	 * @see Extractor#extract(java.lang.String)
	 */
	@Override
	public List<NurseryVacancyInfo> extract(String url) {

		Document doc = getDocument(url);

		List<NurseryVacancyInfo> resList = new ArrayList<>();
		Elements tables = doc.getElementsByClass("table01");

		for (Element table : tables) {
			Elements trs = table.getElementsByTag("tr");
			List<Element> trsList = trs.subList(3, trs.size());

			for (Element tr : trsList) {

				Elements tds = tr.getElementsByTag("td");

				String name = tds.get(0).select("a").text();
				if (tds.size() > 10 && StringUtils.isNotEmpty(name)) {

					if (name.trim().equals("延長保育")) {
						break;
					}

					NurseryVacancyInfo info = new NurseryVacancyInfo();
					info.name = tds.get(0).select("a").text();
					info.zeroCnt = tds.get(3).text().trim();
					info.firstCnt = tds.get(4).text().trim();
					info.secondCnt = tds.get(5).text().trim();
					info.thirdCnt = tds.get(6).text().trim();
					info.fourthCnt = tds.get(7).text().trim();
					info.fifthCnt = tds.get(8).text().trim();

					resList.add(info);
				}
			}
		}

		return resList;
	}
}
