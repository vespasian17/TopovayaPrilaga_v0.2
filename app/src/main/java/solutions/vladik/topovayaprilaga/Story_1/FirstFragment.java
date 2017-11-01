package solutions.vladik.topovayaprilaga.Story_1;

import android.app.AlertDialog;
import android.content.DialogInterface;
import android.os.Bundle;
import android.support.v4.app.Fragment;
import android.text.SpannableString;
import android.text.Spanned;
import android.text.method.LinkMovementMethod;
import android.text.style.ClickableSpan;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;

import solutions.vladik.topovayaprilaga.MainActivity;
import solutions.vladik.topovayaprilaga.R;

/**
 * Created by tim on 28.10.17.
 */

public class FirstFragment extends Fragment {

    @Override
    public void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);

    }

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {

        final View v = inflater.inflate(R.layout.level_1_page_01, container, false);
        TextView tv = (TextView) v.findViewById(R.id.tv_1_1);

        //Фулл текст
        SpannableString ss = new SpannableString("\n \t В начале времен не были в мире ни песка, ни моря, ни волн холодных; земли еще не было, не было небосвода. И только зияла огромная черная бездна ГИНУНГАГАП, или Мировая бездна. К северу от нее был Нифльхейм, Темный мир. Оттуда шел холод и свирепая непогода. А к югу от Мировой бездны располагался мир жара и огня Муспелльхейм. С севера Мировая бездна заполнялась льдом и инеем, а с юга в нее залетали искры из Муспелльхейма. Когда же иней и теплый воздух встретились, иней стал таять, и капли, стекавшие вниз, породили первое существо - великана Имира.\n" +
                "    \n \t Но стоит отметить, что по древнескандинавским поверьям Огненные великаны были раньше Имира, однако именно из тела Имира и был сотворен мир. Возможно поэтому в разных писаниях Имира называют первым существом, древним прародителем всех.\n" +
                "");
        //Действие по клику
        ClickableSpan span1 = new ClickableSpan() {
            @Override
            public void onClick(View textView) {
                //Диалог с описанием
                AlertDialog.Builder builder = new AlertDialog.Builder(textView.getContext());
                builder.setTitle("Пояснение")
                        .setMessage("Бла бла бла описание")
                        .setCancelable(true);
                AlertDialog alert = builder.create();
                alert.show();
            }
        };
        ClickableSpan span2 = new ClickableSpan() {
            @Override
            public void onClick(View textView) {
                // do another thing
            }
        };
        //Добавление нового выделенного слова
        ss.setSpan(span1, 148, 158, Spanned.SPAN_EXCLUSIVE_EXCLUSIVE);
        ss.setSpan(span2, 316, 329, Spanned.SPAN_EXCLUSIVE_EXCLUSIVE);


        tv.setText(ss);
        tv.setMovementMethod(LinkMovementMethod.getInstance());

        return v;
    }
}
