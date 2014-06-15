package jp.co.casleyconsulting.www.nurseryVacancy.extactor.info;

import java.io.IOException;

import org.jsoup.Jsoup;
import org.jsoup.nodes.Document;

/**
 * @author FUJIWARA
 *
 */
public abstract class GeneralInfoExtractor implements InfoExtractor {

	/**
	 * @param url
	 * @return
	 */
	public Document getDocument(String url) {

		Document doc = null;
		try {
			doc = Jsoup.connect(url).get();
		} catch (IOException e) {
			// TODO 自動生成された catch ブロック
			e.printStackTrace();
		}

		return doc;
	}

}
