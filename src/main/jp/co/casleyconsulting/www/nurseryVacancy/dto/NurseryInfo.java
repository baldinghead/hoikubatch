package jp.co.casleyconsulting.www.nurseryVacancy.dto;

/**
 * 保育園情報DTO
 *
 * @author yoshio
 *
 */
public class NurseryInfo {

	public String name;

	/**
	 * 公立/私立などの区分
	 */
	public String kind;

	public String address;

	public String telNo;

	/**
	 * 定員
	 */
	public String quota;

	/**
	 * 受け入れ年齢
	 */
	public String availableAge;

	/**
	 * 基本保育時間
	 */
	public String businessHour;

	/**
	 * 延長保育
	 */
	public String extension;

}
