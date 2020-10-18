package com.company;

import com.company.locale.LocaleProvider;
import com.company.text.Text;
import com.company.text.factory.TextFactory;

import java.util.Locale;

public class Main {
    static String text = """
            hello world
            today rain, and weather is dull...
            
            <code>
            #include <oistream>
          
            int main(){
                cout << "Hello world";
            }
            <code/>
            The self-study lessons in this: section, are written and organised!!!
            according to the levels?! of the Common European. Framework of Res.
            """;

    static String text2 = """
гда человек сознательно или интуитивно выбирает себе в жизни какую-то цель, жизненную задачу, он невольно дает себе оценку. По тому, ради чего человек живет, можно судить и о его самооценке - низкой или высокой.

Если человек живет, чтобы приносить людям добро, облегчать их страдания, давать людям радость, то он оценивает себя на уровне этой своей человечности. Он ставит себе цель, достойную человека.

Только такая цель позволяет человеку прожить свою жизнь с достоинством и получить настоящую радость. Да, радость! Подумайте: если человек ставит себе задачей увеличивать в жизни добро, приносить людям счастье, какие неудачи могут его постигнуть? Не тому помочь? Но много ли людей не нуждаются в помощи?

Если жить только для себя, своими мелкими заботами о собственном благополучии, то от прожитого не останется и следа. Если же жить для других, то другие сберегут то, чему служил, чему отдавал силы.
<code>
            #include <oistream>
          
            int main(){
                cout << "Hello world";
            }
<code/>
гда человек сознательно или интуитивно выбирает себе в жизни какую-то цель, жизненную задачу, он невольно дает себе оценку. По тому, ради чего человек живет, можно судить и о его самооценке - низкой или высокой.

Если человек живет, чтобы приносить людям добро, облегчать их страдания, давать людям радость, то он оценивает себя на уровне этой своей человечности. Он ставит себе цель, достойную человека.

Только такая цель позволяет человеку прожить свою жизнь с достоинством и получить настоящую радость. Да, радость! Подумайте: если человек ставит себе задачей увеличивать в жизни добро, приносить людям счастье, какие неудачи могут его постигнуть? Не тому помочь? Но много ли людей не нуждаются в помощи?

Если жить только для себя, своими мелкими заботами о собственном благополучии, то от прожитого не останется и следа. Если же жить для других, то другие сберегут то, чему служил, чему отдавал силы.
""";


    public static void main(String[] args) {

       // Locale locale = new Locale("en", "GB");
        Locale locale = Locale.getDefault();
        System.out.println(locale.getDisplayCountry());
        LocaleProvider provider = LocaleProvider.instanceOf(locale);

        TextFactory tf = new TextFactory();
        Text text = tf.getText(Main.text2);

        System.out.println("Output text parsed text");
        System.out.println("********************************************************");
        String outputText = text.outputText();
        System.out.println(outputText);

        System.out.println("Output swaped text");
        System.out.println("********************************************************");
        text.swapSentences();
        outputText = text.outputText();
        System.out.println(outputText);

        System.out.println("Output words in alphabet order");
        System.out.println("********************************************************");
        String s = text.printWordsInOrder();
        System.out.println(s);

    }
}
