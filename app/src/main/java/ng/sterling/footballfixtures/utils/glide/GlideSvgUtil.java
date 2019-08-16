package ng.sterling.footballfixtures.utils.glide;

import android.content.Context;
import android.graphics.drawable.PictureDrawable;
import android.net.Uri;
import android.text.TextUtils;
import android.widget.ImageView;

import com.bumptech.glide.RequestBuilder;

import ng.sterling.footballfixtures.R;

import static com.bumptech.glide.load.resource.drawable.DrawableTransitionOptions.withCrossFade;

/**
 * Author: Oluwatobi Adenekan
 * date:    16/08/2019
 **/

public class GlideSvgUtil {

    private ImageView imageView;
    private String imageUrl;
    private RequestBuilder<PictureDrawable> requestBuilder;
    private Context context;

    public int getPlaceHolderImage() {
        return placeHolderImage;
    }

    public GlideSvgUtil setPlaceHolderImage(int placeHolderImage) {
        this.placeHolderImage = placeHolderImage;
        return this;
    }

    private int placeHolderImage;


    private GlideSvgUtil(ImageView imageView, String imageUrl, Context context) {
        this.imageUrl = imageUrl;
        this.imageView = imageView;
        this.context = context;
    }

    private void loadSvg() {
        GlideRequest<PictureDrawable> glideRequest = GlideApp.with(this.context)
                .as(PictureDrawable.class);
        if (placeHolderImage != 0) {

            glideRequest.placeholder(this.placeHolderImage);
        } else {
            glideRequest.placeholder(R.drawable.ic_place);
        }

        this.requestBuilder = glideRequest
                .transition(withCrossFade())
                .listener(new SvgSoftwareLayerSetter());

        loadNet();
    }


    private void loadNet() {
        Uri uri = Uri.parse(this.imageUrl);
        requestBuilder.load(uri).into(this.imageView);
    }


    public static class Builder {
        private int placeHolderImage;
        private ImageView imageView;
        private String imageUrl;
        private Context context;

        public Builder(ImageView imageView, String imageUrl, Context context) {
            this.imageUrl = imageUrl;
            this.imageView = imageView;
            this.context = context;
        }


        public Builder setPlaceHolderImage(int placeHolderImage) {
            this.placeHolderImage = this.placeHolderImage;
            return this;
        }

        public void build() {
            GlideSvgUtil glideSvgUtil = new GlideSvgUtil(this.imageView, this.imageUrl, this.context);
            glideSvgUtil.setPlaceHolderImage(this.placeHolderImage);
            glideSvgUtil.loadSvg();

        }
    }


}
