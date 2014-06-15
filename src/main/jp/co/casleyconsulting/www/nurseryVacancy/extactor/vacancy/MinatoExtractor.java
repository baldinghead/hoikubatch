package jp.co.casleyconsulting.www.nurseryVacancy.extactor.vacancy;

import java.util.ArrayList;
import java.util.List;

import jp.co.casleyconsulting.www.nurseryVacancy.dto.NurseryVacancyInfo;

import org.apache.commons.lang3.StringUtils;
import org.jsoup.nodes.Document;
import org.jsoup.nodes.Element;
import org.jsoup.select.Elements;

/**
 * @author FUJIWARA
 *
 */
public class MinatoExtractor extends GeneralExtractor {

	/*
	 * (非 Javadoc)
	 * 
	 * @see Extractor#extract(java.lang.String)
	 */
	@Override
	public List<NurseryVacancyInfo> extract(String url) {

		Document doc = getDocument(url);

		List<NurseryVacancyInfo> resList = new ArrayList<>();

		// 対象は最初のtableのみ
		Element dataTable = doc.select("table.datatable").first();

		Elements trs = dataTable.select("tr");
		List<Element> trList = trs.subList(2, trs.size());

		for (Element tr : trList) {

			Elements tds = tr.getElementsByTag("td");

			if (StringUtils.isNotEmpty(tds.get(1).text()) && tds.size() >= 7) {

				if (tds.size() == 9) {
					// 区立とか私立とか入ってきた場合は一つ目の要素を削除
					tds.remove(0);
				}

				NurseryVacancyInfo info = new NurseryVacancyInfo();
				info.name = tds.get(0).text();
				info.zeroCnt = tds.get(2).text().trim();
				info.firstCnt = tds.get(3).text().trim();
				info.secondCnt = tds.get(4).text().trim();
				info.thirdCnt = tds.get(5).text().trim();
				if (tds.size() < 8) {
					// ４歳と５歳がcolspanされている場合
					info.fourthAndFifthCnt = tds.get(6).text().trim();
				} else {
					info.fourthCnt = tds.get(6).text().trim();
					info.fifthCnt = tds.get(7).text().trim();
				}

				resList.add(info);
			}
		}

		return resList;
	}
}
