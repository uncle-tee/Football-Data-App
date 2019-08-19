package ng.sterling.footballfixtures.utils.glide;

import android.graphics.drawable.PictureDrawable;

import com.bumptech.glide.load.engine.GlideException;
import com.bumptech.glide.request.RequestListener;
import android.widget.ImageView;
import com.bumptech.glide.load.DataSource;
import com.bumptech.glide.request.target.ImageViewTarget;
import com.bumptech.glide.request.target.Target;

/**
 * Author: Oluwatobi Adenekan
 * date:    16/08/2019
 **/

public class SvgSoftwareLayerSetter implements RequestListener<PictureDrawable> {

    @Override
    public boolean onLoadFailed(
            GlideException e, Object model, Target<PictureDrawable> target, boolean isFirstResource) {
        ImageView view = ((ImageViewTarget<?>) target).getView();
        view.setLayerType(ImageView.LAYER_TYPE_NONE, null);
        return false;
    }

    @Override
    public boolean onResourceReady(
            PictureDrawable resource,
            Object model,
            Target<PictureDrawable> target,
            DataSource dataSource,
            boolean isFirstResource) {
        ImageView view = ((ImageViewTarget<?>) target).getView();
        view.setLayerType(ImageView.LAYER_TYPE_SOFTWARE, null);
        return false;
    }
}