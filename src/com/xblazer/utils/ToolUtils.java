package com.xblazer.utils;

import com.alibaba.druid.util.StringUtils;

import java.math.BigDecimal;
import java.text.DecimalFormat;
import java.util.UUID;

/**
 * 公共工具类
 * @author NCIT
 */
public class ToolUtils {


	/**
	 * double精度调整
	 * 
	 * @param doubleValue
	 *            需要调整的值123.454
	 * @param format
	 *            目标样式".##"
	 * @return
	 */
	public static String decimalFormatToString(double doubleValue, String format) {
		DecimalFormat myFormatter = new DecimalFormat(format);
		String formatValue = myFormatter.format(doubleValue);
		return formatValue;
	}

	/**
	 * 获取UUID by jdk
	 * 
	 * @return
	 */
	public static String getUuidByJdk(boolean is32bit) {
		String uuid = UUID.randomUUID().toString();
		if (is32bit) {
			return uuid.toString().replace("-", "");
		}
		return uuid;
	}

	/**
	 * 仅用于从map中读取数值类型时，转化使用
	 * @param val
	 * @return
	 */
	public static int objToint(Object val) {
		if (val == null || StringUtils.isEmpty(val.toString())) {
			return 0;
		} else {
			return Integer.parseInt(val.toString());
		}
	}
	
	/**
	 * 仅用于从map中读取数值类型时，转化使用
	 * @param val
	 * @return
	 */
	public static long objTolong(Object val) {
		if (val == null || StringUtils.isEmpty(val.toString())) {
			return 0L;
		} else {
			return Long.parseLong(val.toString());
		}
	}
	
	public static void main(String[] args) {
		System.out.println(getUuidByJdk(true));
	}

    /**
     * 根据两点经纬度计算两点间的距离（Android算法）
     * 
     * @param lat1 A点纬度
     * @param lon1 A点经度
     * @param lat2 B点纬度
     * @param lon2 B点经度
     * @return 地球上两点间距离
     */
    public static String computeDistanceKM(double lat1, double lon1, double lat2, double lon2) {

        double distance = computeDistance(lat1, lon1, lat2, lon2);
        BigDecimal bg = new BigDecimal(distance);
        BigDecimal bgDistance = bg.divide(new BigDecimal(1000));
        return "" + bgDistance.setScale(2, BigDecimal.ROUND_HALF_UP).doubleValue() + "公里";
    }


    /**
     * 根据两点经纬度计算两点间的距离（Android算法）
     * 
     * @param lat1
     *            A点纬度
     * @param lon1
     *            A点经度
     * @param lat2
     *            B点纬度
     * @param lon2
     *            B点经度
     * @return 地球上两点间距离
     */
    public static double computeDistance(double lat1, double lon1, double lat2,
            double lon2) {
        // Based on http://www.ngs.noaa.gov/PUBS_LIB/inverse.pdf
        // using the "Inverse Formula" (section 4)

        int MAXITERS = 20;
        // Convert lat/long to radians
        lat1 *= Math.PI / 180.0;
        lat2 *= Math.PI / 180.0;
        lon1 *= Math.PI / 180.0;
        lon2 *= Math.PI / 180.0;

        double a = 6378137.0; // WGS84 major axis
        double b = 6356752.3142; // WGS84 semi-major axis
        double f = (a - b) / a;
        double aSqMinusBSqOverBSq = (a * a - b * b) / (b * b);

        double L = lon2 - lon1;
        double A = 0.0;
        double U1 = Math.atan((1.0 - f) * Math.tan(lat1));
        double U2 = Math.atan((1.0 - f) * Math.tan(lat2));

        double cosU1 = Math.cos(U1);
        double cosU2 = Math.cos(U2);
        double sinU1 = Math.sin(U1);
        double sinU2 = Math.sin(U2);
        double cosU1cosU2 = cosU1 * cosU2;
        double sinU1sinU2 = sinU1 * sinU2;

        double sigma = 0.0;
        double deltaSigma = 0.0;
        double cosSqAlpha = 0.0;
        double cos2SM = 0.0;
        double cosSigma = 0.0;
        double sinSigma = 0.0;
        double cosLambda = 0.0;
        double sinLambda = 0.0;

        double lambda = L; // initial guess
        for (int iter = 0; iter < MAXITERS; iter++) {
            double lambdaOrig = lambda;
            cosLambda = Math.cos(lambda);
            sinLambda = Math.sin(lambda);
            double t1 = cosU2 * sinLambda;
            double t2 = cosU1 * sinU2 - sinU1 * cosU2 * cosLambda;
            double sinSqSigma = t1 * t1 + t2 * t2; // (14)
            sinSigma = Math.sqrt(sinSqSigma);
            cosSigma = sinU1sinU2 + cosU1cosU2 * cosLambda; // (15)
            sigma = Math.atan2(sinSigma, cosSigma); // (16)
            double sinAlpha = (sinSigma == 0) ? 0.0 : cosU1cosU2 * sinLambda
                    / sinSigma; // (17)
            cosSqAlpha = 1.0 - sinAlpha * sinAlpha;
            cos2SM = (cosSqAlpha == 0) ? 0.0 : cosSigma - 2.0 * sinU1sinU2
                    / cosSqAlpha; // (18)

            double uSquared = cosSqAlpha * aSqMinusBSqOverBSq; // defn
            A = 1
                    + (uSquared / 16384.0)
                    * // (3)
                    (4096.0 + uSquared
                            * (-768 + uSquared * (320.0 - 175.0 * uSquared)));
            double B = (uSquared / 1024.0) * // (4)
                    (256.0 + uSquared
                            * (-128.0 + uSquared * (74.0 - 47.0 * uSquared)));
            double C = (f / 16.0) * cosSqAlpha
                    * (4.0 + f * (4.0 - 3.0 * cosSqAlpha)); // (10)
            double cos2SMSq = cos2SM * cos2SM;
            deltaSigma = B
                    * sinSigma
                    * // (6)
                    (cos2SM + (B / 4.0)
                            * (cosSigma * (-1.0 + 2.0 * cos2SMSq) - (B / 6.0)
                                    * cos2SM
                                    * (-3.0 + 4.0 * sinSigma * sinSigma)
                                    * (-3.0 + 4.0 * cos2SMSq)));

            lambda = L
                    + (1.0 - C)
                    * f
                    * sinAlpha
                    * (sigma + C
                            * sinSigma
                            * (cos2SM + C * cosSigma
                                    * (-1.0 + 2.0 * cos2SM * cos2SM))); // (11)

            double delta = (lambda - lambdaOrig) / lambda;
            if (Math.abs(delta) < 1.0e-12) {
                break;
            }
        }

        return b * A * (sigma - deltaSigma);
    }

}
