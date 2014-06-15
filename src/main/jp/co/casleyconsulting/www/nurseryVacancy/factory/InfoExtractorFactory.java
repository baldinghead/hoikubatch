package jp.co.casleyconsulting.www.nurseryVacancy.factory;

import jp.co.casleyconsulting.www.nurseryVacancy.constants.ExtractType;
import jp.co.casleyconsulting.www.nurseryVacancy.extactor.info.InfoExtractor;
import jp.co.casleyconsulting.www.nurseryVacancy.extactor.info.NakanoInfoExtractor;

/**
 * Extractorを返します
 *
 * @author FUJIWARA
 *
 */
public class InfoExtractorFactory {

	/**
	 * @param type
	 * @return
	 */
	public static InfoExtractor create(ExtractType type) {

		switch (type) {
		case NAKANO:

			return new NakanoInfoExtractor();

		default:
			break;
		}

		return null;
	}
}
