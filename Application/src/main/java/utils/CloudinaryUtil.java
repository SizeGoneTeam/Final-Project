package utils;

import com.cloudinary.*;
import com.cloudinary.utils.ObjectUtils;

public class CloudinaryUtil {
    public static Cloudinary cloudinary;

    public static Cloudinary getCloudinary() {
        if(cloudinary == null)
        {
             cloudinary = new Cloudinary(ObjectUtils.asMap(
                    "cloud_name", "dzchykus4",
                    "api_key", "657243456688262",
                    "api_secret", "c1jYKBVDqc127TAtUWhT-a8Byzk",
                    "secure", true));
        }
            
        return cloudinary;
    }

}
