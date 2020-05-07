package com.example.teacher.Manager.Fragment;



import android.content.Intent;
import android.graphics.Bitmap;
import android.net.Uri;
import android.os.Bundle;
import androidx.fragment.app.Fragment;

import android.os.Environment;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Button;
import android.widget.EditText;
import android.widget.ImageView;
import android.widget.Toast;

import com.example.teacher.R;
import com.google.zxing.BarcodeFormat;
import com.google.zxing.EncodeHintType;
import com.google.zxing.MultiFormatWriter;
import com.google.zxing.WriterException;
import com.google.zxing.common.BitMatrix;

import java.io.File;
import java.io.FileOutputStream;
import java.io.IOException;
import java.util.Hashtable;



public class SeatCodeFragment extends Fragment {

    private EditText Sbool,Sfool,Sroom,Snum,Slat,Slong;
    private ImageView code;
    private Button creat;

    private Bitmap bm;

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        View view=inflater.inflate(R.layout.fragment_seat_code, container, false);
        Sbool=view.findViewById(R.id.SBool);
        Sfool=view.findViewById(R.id.Sfool);
        Sroom=view.findViewById(R.id.Sroom);
        Snum=view.findViewById(R.id.Snum);
        Slat=view.findViewById(R.id.SLat);
        Slong=view.findViewById(R.id.SLong);
        code=view.findViewById(R.id.Codeimg);
        code.setOnLongClickListener(new View.OnLongClickListener() {
            @Override
            public boolean onLongClick(View v) {
                SaveImage(bm);

            return true;}
        });

        creat=view.findViewById(R.id.Creatcode);
        creat.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                String sbool=Sbool.getText().toString().trim();
                String sfool=Sfool.getText().toString().trim();
                String sroom=Sroom.getText().toString().trim();
                String snum=Snum.getText().toString().trim();
                String slat=Slat.getText().toString().trim();
                String slong=Slong.getText().toString().trim();

                String contents =sbool+sfool+sroom+snum+slat+slong;

                try {
                    bm = qr_code(contents, BarcodeFormat.QR_CODE);
                    code.setImageBitmap(bm);
                } catch (
                        WriterException e) {

                    e.printStackTrace();
                }
            }
        });

        return view;

    }


    public Bitmap qr_code(String string, BarcodeFormat format) throws WriterException {
        MultiFormatWriter writer = new MultiFormatWriter();
        Hashtable<EncodeHintType, String> hst = new Hashtable<EncodeHintType, String>();
        hst.put(EncodeHintType.CHARACTER_SET, "UTF-8");
        BitMatrix matrix = writer.encode(string, format, 400, 400, hst);
        int width = matrix.getWidth();
        int height = matrix.getHeight();
        int[] pixels = new int[width * height];
        for (int y = 0; y < height; y++) {
            for (int x = 0; x < width; x++) {
                if (matrix.get(x, y)) {
                    pixels[y * width + x] = 0xff000000;
                }

            }
        }
        Bitmap bitmap = Bitmap.createBitmap(width, height,
                Bitmap.Config.ARGB_8888);
        // 通过像素数组生成bitmap
        bitmap.setPixels(pixels, 0, width, 0, 0, width, height);

        return bitmap;
    }


    private void SaveImage(Bitmap bitmap){
        String fileName = "qr_"+System.currentTimeMillis() + ".jpg";
        boolean isSaveSuccess =saveImageToGallery(bitmap,fileName);
        if (isSaveSuccess) {
            Toast.makeText(getActivity(), "图片已保存至本地", Toast.LENGTH_LONG).show();
        } else {
            Toast.makeText(getActivity(), "保存图片失败，请稍后重试", Toast.LENGTH_SHORT).show();
        }
    }

     private boolean saveImageToGallery(Bitmap bitmap, String fileName) {
        // 保存图片至指定路径
       //String storePath=Environment.getExternalStorageDirectory().getAbsolutePath() + File.separator + "qrcode";
//       File appDir = new File(Environment.getExternalStorageDirectory(),"qrcode");
//
//        if (!appDir.exists()) {
//            appDir.mkdir();
//        }

         File filepath=getContext().getFilesDir();
        File file = new File(filepath, fileName);
        try {
            FileOutputStream fos = new FileOutputStream(file);
            //通过io流的方式来压缩保存图片(80代表压缩20%)
            boolean isSuccess = bitmap.compress(Bitmap.CompressFormat.JPEG, 80, fos);
            fos.flush();
            fos.close();

            //发送广播通知系统图库刷新数据
            Uri uri = Uri.fromFile(file);
            getActivity().sendBroadcast(new Intent(Intent.ACTION_MEDIA_SCANNER_SCAN_FILE, uri));
            if (isSuccess) {
                return true;
            } else {
                return false;
            }
        } catch (IOException e) {
            e.printStackTrace();
        }
        return false;
    }


}
