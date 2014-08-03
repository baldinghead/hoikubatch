package jp.co.casleyconsulting.www.nurseryVacancy.extactor.vacancy;

import java.util.ArrayList;
import java.util.List;

import jp.co.casleyconsulting.www.nurseryVacancy.constants.ExtractType;
import jp.co.casleyconsulting.www.nurseryVacancy.dto.NurseryVacancyInfo;

import org.apache.commons.lang3.StringUtils;
import org.jsoup.nodes.Document;
import org.jsoup.nodes.Element;
import org.jsoup.select.Elements;

/**
 * @author FUJIWARA
 * 
 */
public class NakanoExtractor extends GeneralExtractor {

	/*
	 * (非 Javadoc)
	 * 
	 * @see Extractor#extract(java.lang.String)
	 */
	@Override
	public List<NurseryVacancyInfo> extract(String url) {

		Document doc = getDocument(url);

		List<NurseryVacancyInfo> resList = new ArrayList<>();
		Element table = doc.getElementsByTag("table").first();
		Elements trs = table.getElementsByTag("tr");
		List<Element> trsList = trs.subList(1, trs.size());
		for (Element tr : trsList) {

			Elements tds = tr.getElementsByTag("td");

			if (tds.size() > 5 && StringUtils.isNotEmpty(tds.get(1).text())) {

				NurseryVacancyInfo info = new NurseryVacancyInfo();
				info.extractType = ExtractType.NAKANO;
				info.name = tds.get(0).text().trim();
				info.zeroCnt = tds.get(1).text().trim();
				info.firstCnt = tds.get(2).text().trim();
				info.secondCnt = tds.get(3).text().trim();
				info.thirdCnt = tds.get(4).text().trim();
				info.fourthCnt = tds.get(5).text().trim();
				info.fifthCnt = tds.get(6).text().trim();

				resList.add(info);
			}
		}

		return resList;
	}
}
