package com.yiw.circledemo;

import android.content.Context;
import android.os.Environment;

import com.bumptech.glide.Glide;
import com.bumptech.glide.GlideBuilder;
import com.bumptech.glide.load.engine.cache.InternalCacheDiskCacheFactory;
import com.bumptech.glide.module.GlideModule;

import java.io.File;

/**
 * Created by suneee on 2016/6/6.
 */
public class MyGlideModule implements GlideModule {

    // 默认存放图片的路径
    public final static String DEFAULT_SAVE_IMAGE_PATH = Environment.getExternalStorageDirectory() + File.separator + "CircleDemo" + File.separator + "Images"
            + File.separator;

    //设置一个用来创建DiskCache的工厂。默认情况下Glide使用InternalCacheDiskCacheFactory内部工厂类创建DiskCache，
    // 缓存目录为程序内部缓存目录/data/data/your_package_name/image_manager_disk_cache/(不能被其它应用访问)且缓存最大为250MB。
    // 当然，可以通过InternalCacheDiskCacheFactory构造器更改缓存的目录和最大缓存大小，如：
    @Override
    public void applyOptions(Context context, GlideBuilder builder) {
        builder.setDiskCache(
                new InternalCacheDiskCacheFactory(context, DEFAULT_SAVE_IMAGE_PATH, 50 * 1024 * 1024));
    }

    //用来在Glide单例创建之后但请求发起之前注册组件，该方法每次实现只会被调用一次。通常在该方法中注册ModelLoader。
    @Override
    public void registerComponents(Context context, Glide glide) {

    }
}
