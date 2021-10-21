package seedu.duke.list;

import java.util.ArrayList;
import seedu.duke.hospital.Hospital;

public class HospitalList {

    // Hospital variables
    String CHANGI_GENERAL_HOSPITAL = "changi general hospital";
    Integer CHANGI_GENERAL_HOSPITAL_NUMBER = 67888833;
    String KHOO_TECK_PUAT_HOSPITAL = "khoo teck puat hospital";
    Integer KHOO_TECK_PUAT_HOSPITAL_NUMBER = 65558000;
    String NATIONAL_UNIVERSITY_HOSPITAL = "national university hospital";
    Integer NATIONAL_UNIVERSITY_HOSPITAL_NUMBER = 67795555;
    String NG_TENG_FONG_GENERAL_HOSPITAL = "ng teng feng general hospital";
    Integer NG_TENG_FONG_GENERAL_HOSPITAL_NUMBER = 67162000;
    String SINGAPORE_GENERAL_HOSPITAL = "singapore general hospital";
    Integer SINGAPORE_GENERAL_HOSPITAL_NUMBER = 62223322;
    String TAN_TOCK_SENG_HOSPITAL = "tan tock seng hospital";
    Integer TAN_TOCK_SENG_HOSPITAL_NUMBER = 62566011;

    //Changi General Hospital doctor variables
    String MA_XUEGANG = "ma xuegang";
    Integer MA_XUEGANG_NUMBER = 97587759;
    String XIE_FANG = "xie fang";
    Integer XIE_FANG_NUMBER = 99577818;
    String PETER_GANG = "peter gang";
    Integer PETER_GANG_NUMBER = 94501442;
    String JON_YI = "jon yi";
    Integer JON_YI_NUMBER = 83027553;
    String HAN_GUANTING = "han guanting";
    Integer HAN_GUANTING_NUMBER = 95674975;

    //Khoo Teck Puat Hospital doctor variables
    String ADRIAN_VERGIL = "adrian vergil";
    Integer ADRIAN_VERGIL_NUMBER = 88129931;
    String JOLINE_DEAN = "joline dean";
    Integer JOLINE_DEAN_NUMBER = 98672657;
    String BRITNEY_SOH = "britney soh";
    Integer BRITNEY_SOH_NUMBER = 91982575;
    String SHUI_LORIN = "shui lorin";
    Integer SHUI_LORIN_NUMBER = 99046617;
    String ADITI_NITYA = "aditi nitya";
    Integer ADITI_NITYA_NUMBER = 91208702;

    //National University Hospital doctor variables
    String DWAIN_WONG = "dwain wong";
    Integer DWAIN_WONG_NUMBER = 98105561;
    String LIM_QINGCHEN = "lim qingchen";
    Integer LIM_QINGCHEN_NUMBER = 96737937;
    String LING_LI_SE = "ling li se";
    Integer LING_LI_SE_NUMBER = 83892911;
    String JUAN_CHELSIE = "juan chelsie";
    Integer JUAN_CHELSIE_NUMBER = 97915260;
    String LORIE_PANG = "lorie pang";
    Integer LORIE_PANG_NUMBER = 88235081;

    //Ng Teng Fong Hospital doctor variables
    String SUN_GENGXIN = "sun gengxin";
    Integer SUN_GENGXIN_NUMBER = 98770442;
    String DAI_JIA = "dai jia";
    Integer DAI_JIA_NUMBER = 84357329;
    String XAVIER_YUAN = "xavier yuan";
    Integer XAVIER_YUAN_NUMBER = 80270436;
    String ZENG_ZEMIN = "zeng zemin";
    Integer ZENG_ZEMIN_NUMBER = 82609095;
    String FU_JING = "fu jing";
    Integer FU_JING_NUMBER = 99444710;

    //Singapore General Hospital doctor variables
    String NILOFER_SIDDHI = "nilofer siddhi";
    Integer NILOFER_SIDDHI_NUMBER = 92834168;
    String TARAN_NIRMALA = "taran nirmala";
    Integer TARAN_NIRMALA_NUMBER = 90877889;
    String PAXTON_JERROD = "paxton jerrod";
    Integer PAXTON_JERROD_NUMBER = 94424161;
    String PIERS_COLEMAN = "piers coleman";
    Integer PIERS_COLEMAN_NUMBER = 99350450;
    String TAN_CAILIN = "tan cailin";
    Integer TAN_CAILIN_NUMBER = 99897593;

    //Tan Tock Seng Hospital doctor variables
    String MARALYN_HARSHA = "maralyn harsha";
    Integer MARALYN_HARSHA_NUMBER = 99026440;
    String STACE_FANG = "stace fang";
    Integer STACE_FANG_NUMBER = 91074243;
    String CHANTELLE_JIA = "chantelle jia";
    Integer CHANTELLE_JIA_NUMBER = 80463166;
    String YASMIN_ANG = "yasmin ang";
    Integer YASMIN_ANG_NUMBER = 81338150;
    String WOLF_EMMET = "wolf emmet";
    Integer WOLF_EMMET_NUMBER = 89490406;


    protected ArrayList<Hospital> hospitalArrayList = new ArrayList<Hospital>();

    public HospitalList() {
    }

    public void initHospitals () {
        hospitalArrayList.add(initChangiGeneralHospital());
        hospitalArrayList.add(initKhooTeckPuatHospital());
        hospitalArrayList.add(initNationalUniversityHospital());
        hospitalArrayList.add(initNgTengFongHospital());
        hospitalArrayList.add(initSingaporeGeneralHospital());
        hospitalArrayList.add(initTanTockSengHospital());
    }

    private Hospital initChangiGeneralHospital() {
        Hospital changiGeneralHospital = new Hospital(CHANGI_GENERAL_HOSPITAL, CHANGI_GENERAL_HOSPITAL_NUMBER);
        changiGeneralHospital.addDoctor(MA_XUEGANG, MA_XUEGANG_NUMBER);
        changiGeneralHospital.addDoctor(XIE_FANG, XIE_FANG_NUMBER);
        changiGeneralHospital.addDoctor(PETER_GANG, PETER_GANG_NUMBER);
        changiGeneralHospital.addDoctor(JON_YI, JON_YI_NUMBER);
        changiGeneralHospital.addDoctor(HAN_GUANTING, HAN_GUANTING_NUMBER);
        return changiGeneralHospital;
    }

    private Hospital initKhooTeckPuatHospital() {
        Hospital khooTeckPuatHospital = new Hospital(KHOO_TECK_PUAT_HOSPITAL, KHOO_TECK_PUAT_HOSPITAL_NUMBER);
        khooTeckPuatHospital.addDoctor(ADRIAN_VERGIL, ADRIAN_VERGIL_NUMBER);
        khooTeckPuatHospital.addDoctor(JOLINE_DEAN, JOLINE_DEAN_NUMBER);
        khooTeckPuatHospital.addDoctor(SHUI_LORIN, SHUI_LORIN_NUMBER);
        khooTeckPuatHospital.addDoctor(BRITNEY_SOH, BRITNEY_SOH_NUMBER);
        khooTeckPuatHospital.addDoctor(ADITI_NITYA, ADITI_NITYA_NUMBER);
        return khooTeckPuatHospital;
    }

    private Hospital initNationalUniversityHospital() {
        Hospital nationalUniversityHospital = new Hospital(NATIONAL_UNIVERSITY_HOSPITAL,
                NATIONAL_UNIVERSITY_HOSPITAL_NUMBER);
        nationalUniversityHospital.addDoctor(DWAIN_WONG, DWAIN_WONG_NUMBER);
        nationalUniversityHospital.addDoctor(LIM_QINGCHEN, LIM_QINGCHEN_NUMBER);
        nationalUniversityHospital.addDoctor(LING_LI_SE, LING_LI_SE_NUMBER);
        nationalUniversityHospital.addDoctor(JUAN_CHELSIE, JUAN_CHELSIE_NUMBER);
        nationalUniversityHospital.addDoctor(LORIE_PANG, LORIE_PANG_NUMBER);
        return nationalUniversityHospital;
    }

    private Hospital initNgTengFongHospital() {
        Hospital ngTengFongHospital = new Hospital(NG_TENG_FONG_GENERAL_HOSPITAL, NG_TENG_FONG_GENERAL_HOSPITAL_NUMBER);
        ngTengFongHospital.addDoctor(SUN_GENGXIN, SUN_GENGXIN_NUMBER);
        ngTengFongHospital.addDoctor(DAI_JIA, DAI_JIA_NUMBER);
        ngTengFongHospital.addDoctor(ZENG_ZEMIN, ZENG_ZEMIN_NUMBER);
        ngTengFongHospital.addDoctor(FU_JING, FU_JING_NUMBER);
        return ngTengFongHospital;

    }

    private Hospital initSingaporeGeneralHospital() {
        Hospital singaporeGeneralHospital = new Hospital(SINGAPORE_GENERAL_HOSPITAL, SINGAPORE_GENERAL_HOSPITAL_NUMBER);
        singaporeGeneralHospital.addDoctor(NILOFER_SIDDHI, NILOFER_SIDDHI_NUMBER);
        singaporeGeneralHospital.addDoctor(TARAN_NIRMALA, TARAN_NIRMALA_NUMBER);
        singaporeGeneralHospital.addDoctor(PAXTON_JERROD, PAXTON_JERROD_NUMBER);
        singaporeGeneralHospital.addDoctor(PIERS_COLEMAN, PIERS_COLEMAN_NUMBER);
        singaporeGeneralHospital.addDoctor(TAN_CAILIN, TAN_CAILIN_NUMBER);
        return singaporeGeneralHospital;
    }

    private Hospital initTanTockSengHospital() {
        Hospital tanTockSengHospital = new Hospital(TAN_TOCK_SENG_HOSPITAL, TAN_TOCK_SENG_HOSPITAL_NUMBER);
        tanTockSengHospital.addDoctor(MARALYN_HARSHA, MARALYN_HARSHA_NUMBER);
        tanTockSengHospital.addDoctor(STACE_FANG, STACE_FANG_NUMBER);
        tanTockSengHospital.addDoctor(CHANTELLE_JIA, CHANTELLE_JIA_NUMBER);
        tanTockSengHospital.addDoctor(YASMIN_ANG, YASMIN_ANG_NUMBER);
        tanTockSengHospital.addDoctor(WOLF_EMMET, WOLF_EMMET_NUMBER);
        return tanTockSengHospital;
    }
}
