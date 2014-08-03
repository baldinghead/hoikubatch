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
public class MeguroExtractor extends GeneralExtractor {

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
		Element dataTable = doc.select("table.table01").first();

		Elements trs = dataTable.select("tr");
		// タイトル行と合計行を除く
		List<Element> trList = trs.subList(1, trs.size() - 1);

		for (Element tr : trList) {

			Elements tds = tr.getElementsByTag("td");

			if (StringUtils.isNotEmpty(tds.get(2).text())) {

				NurseryVacancyInfo info = new NurseryVacancyInfo();
				info.extractType = ExtractType.MEGURO;
				info.name = cleanse(tds.get(0).text());
				info.zeroCnt = cleanse(tds.get(1).text());
				info.firstCnt = cleanse(tds.get(2).text());
				info.secondCnt = cleanse(tds.get(3).text());
				info.thirdCnt = cleanse(tds.get(4).text());
				info.fourthCnt = cleanse(tds.get(5).text());
				info.fifthCnt = cleanse(tds.get(6).text());

				resList.add(info);
			}
		}

		return resList;
	}

	private String cleanse(String val) {
		val = StringUtils.replace(val, " ", "");
		if (StringUtils.isEmpty(val)) {
			return "0";
		}

		return val;
	}
}
