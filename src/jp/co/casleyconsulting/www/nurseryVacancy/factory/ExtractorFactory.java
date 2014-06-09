package jp.co.casleyconsulting.www.nurseryVacancy.factory;

import jp.co.casleyconsulting.www.nurseryVacancy.constants.ExtractType;
import jp.co.casleyconsulting.www.nurseryVacancy.extactor.Extractor;
import jp.co.casleyconsulting.www.nurseryVacancy.extactor.KatsushikaExtractor;
import jp.co.casleyconsulting.www.nurseryVacancy.extactor.NakanoExtractor;
import jp.co.casleyconsulting.www.nurseryVacancy.extactor.SetagayaExtractor;
import jp.co.casleyconsulting.www.nurseryVacancy.extactor.ShinjukuExtractor;
import jp.co.casleyconsulting.www.nurseryVacancy.extactor.TaitoExtractor;
import jp.co.casleyconsulting.www.nurseryVacancy.extactor.ToshimaExtractor;

/**
 * @author FUJIWARA
 * 
 */
public class ExtractorFactory {

	/**
	 * @param type
	 * @return
	 */
	public static Extractor create(ExtractType type) {

		switch (type) {
		case NAKANO:

			return new NakanoExtractor();

		case SHINJUKU:

			return new ShinjukuExtractor();

		case KATSUSHIKA:

			return new KatsushikaExtractor();

		case TAITO:

			return new TaitoExtractor();

		case SETAGAYA:

			return new SetagayaExtractor();

		case TOSHIMA:

			return new ToshimaExtractor();

		default:
			break;
		}

		return null;
	}
}
