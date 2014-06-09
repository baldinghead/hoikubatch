package jp.co.casleyconsulting.www.nurseryVacancy.extactor;

import java.util.List;

import jp.co.casleyconsulting.www.nurseryVacancy.dto.NurseryVacancyInfo;

/**
 * @author FUJIWARA
 * 
 */
public interface Extractor {

	/**
	 * @param doc
	 * @return
	 */
	List<NurseryVacancyInfo> extract(String url);
}
