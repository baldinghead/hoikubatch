package jp.co.casleyconsulting.www.nurseryVacancy.extactor.info;

import java.util.List;

import jp.co.casleyconsulting.www.nurseryVacancy.dto.NurseryInfo;

/**
 * @author FUJIWARA
 *
 */
public interface InfoExtractor {

	/**
	 * @param doc
	 * @return
	 */
	List<NurseryInfo> extract(String url);
}
