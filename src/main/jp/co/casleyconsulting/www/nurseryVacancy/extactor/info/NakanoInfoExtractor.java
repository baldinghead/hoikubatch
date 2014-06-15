package jp.co.casleyconsulting.www.nurseryVacancy.extactor.info;

import java.util.ArrayList;
import java.util.List;

import jp.co.casleyconsulting.www.nurseryVacancy.dto.NurseryInfo;

import org.apache.commons.lang3.StringUtils;
import org.jsoup.nodes.Document;
import org.jsoup.nodes.Element;
import org.jsoup.select.Elements;

/**
 * 中野の保育園情報スクレイピング
 *
 * @author yoshio
 *
 */
public class NakanoInfoExtractor extends GeneralInfoExtractor {

	public List<NurseryInfo> extract(String url) {

		Document doc = getDocument(url);

		List<NurseryInfo> resList = new ArrayList<>();
		Elements tables = doc.select("table");
		// 認可と認証だけ取り出す
		List<Element> targets = tables.subList(0, 2);
		for (Element table : targets) {

			Elements trs = table.select("tr");

			for (Element tr : trs) {

				Elements tds = tr.getElementsByTag("td");

				if (tds.size() >= 7
								&& StringUtils.isNotEmpty(tds.get(0).text())) {

					NurseryInfo info = new NurseryInfo();
					info.name = tds.get(0).text();
					info.kind = tds.get(1).text().trim();
					info.address = tds.get(2).text().trim();
					info.telNo = tds.get(3).text().trim();
					info.quota = tds.get(4).text().trim();
					info.availableAge = tds.get(5).text().trim();
					info.businessHour = tds.get(6).text().trim();
					if (tds.size() == 8) {
						// 認可保育園だけ延長保育の項目がある
						info.extension = tds.get(7).text().trim();
					}

					resList.add(info);
				}
			}
		}

		return resList;
	}
}
