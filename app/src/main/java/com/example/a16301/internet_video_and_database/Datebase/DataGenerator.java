

package com.example.a16301.internet_video_and_database.Datebase;


import com.example.a16301.internet_video_and_database.Datebase.Entity.trainner_info;
import com.example.a16301.internet_video_and_database.Datebase.Entity.tranner_article;

import java.util.ArrayList;
import java.util.Date;
import java.util.List;
import java.util.Random;
import java.util.concurrent.TimeUnit;

/**
 * Generates data to pre-populate the database
 */
public class DataGenerator {

    private static final String[] NAME = new String[]{
            "李红", "张勇", "韩雪", "蔡田"};

    private static final String[] PHONE = new String[]{
            "18801119876", "18801119874",
            "18801119872", "18801119873"};

    private static final String[] SEX = new String[]{
            "女", "男",
            "女", "男"};

    private static final String[] COUSE = new String[]{
            "跑步", "拳击",
            "瑜伽", "器械"};



    private static final String[] TITLE = new String[]{
            "让你明白“健身”是非做不可的事", "要么读书,要么健身",
            "翻天覆地的变化让人感叹", "高颜值和傲人身材的标配"};

    private static final String[] CONTENT = new String[]{
            "健身是一种习惯\n" +
                    "\n" +
                    "如果你从不运动\n" +
                    "\n" +
                    "如果你毕业很多年\n" +
                    "\n" +
                    "你的身体轨迹大概是这样的：\n" +
                    "\n" +
                    "刚毕业，身体脂肪含量10%-13%"+"毕业10年以上，身体脂肪含量30%以上\n" +
                    "\n" +
                    "而毕业10年以上\n" +
                    "\n" +
                    "身体的脂肪量超过30%后\n" +
                    "\n" +
                    "你的身体也就开始走下坡路了\n" +
                    "\n" +
                    "一胖生百病，你的噩梦就开始了", "要么健身，要么读书，身体和灵魂，必须有一个在路上。在等待的日子里，刻苦读书，锻炼身体，谦卑做人，养得深根，日后才能枝叶茂盛。比起后悔，我更喜欢第二天的酸痛，生活从未变得轻松，是你在一点一点变强大。懒惰是很奇怪的东西，它使你以为那是安逸，是休息，是福气；但实际上它所给你的是无聊，是倦怠，是消沉；它剥夺你对前途的希望，割断你和别人之间的友情，使你心胸日渐狭窄，对人生也越来越怀疑。\n" +
            "\n" +
            "有时候，一旦你开始跑步，就只跑了10分钟，便会顺其自然完成整段路线，并获得极大的满足感。\n" +
            "\n" +
            "当没有动力的时候，想想之前跑完每段路程后的喜悦及轻松心情，你的犹豫就会烟消云散，开始只往前跑。\n" +
            "\n" +
            "不要让你在你最美好的时光里成为一个胖子。\n" +
            "\n" +
            "同样地，你跑过的路从来不会欺骗你，他们沉淀在你的精气神中，你的改变谁都可以感受到。\n" +
            "\n" +
            "最怕一个人摆出一副苦样，你对自己都没信心，别人怎么会对你有信心？工作不顺可以宣泄，感情不顺就顺其自然。\n" +
            "\n" +
            "对外表不满，你可以从其他方面努力，生活不顺，可以看书静心，总能找到对自己负责的办法，最没用就是摆出我最惨的样子，实在不行让自己放松几天，看场电影，出去跑步！\n" +
            "\n" +
            "所以请不要说：等我有时间了，就能去运动了。等我赚够钱了，就能孝敬父母了。等我有空了，就能陪你了，等我发达了，就能行善了，等到我们有钱了，健康已经没了。\n" +
            "\n" +
            "等到我们赚够钱了，父母已经等不及了，等到我们真正有空了，爱人已经离开了，等到发达了，心态也已经变了。",
            "健身界有越来越多的年轻人崛起,很多人也因健身被大家熟知，有位来自国外的小伙子年仅21岁，但是在健身界也算是小有名气了。\n" +
                    "\n" +
                    "健身6年的小伙子舍弃美食，翻天覆地的变化让人感叹 - 图片1\n" +
                    "健身时间已有6年，从13年开始健身，现在早已不是当年的瘦弱小伙子了。这样的清晰可见的腹肌，和青筋暴起的双臂，需要付出很大的努力。有人更是因为他这样的逆袭关注他，现在在社交网络上有着不小的粉丝量。\n" +
                    "\n" +
                    "健身6年的小伙子舍弃美食，翻天覆地的变化让人感叹 - 图片2\n" +
                    "小伙子叫做Aaron，以前也与很多人一样喜欢吃喝玩乐，但是最后慢慢的一些娱乐活动都不去了，整天泡在健身房中，有舍便有得，Aaron也因此拥有了更加强壮帅气的肌肉，靠着自己的努力Aaron参加了一场健体比赛成功获冠。\n" +
                    "\n" +
                    "健身6年的小伙子舍弃美食，翻天覆地的变化让人感叹 - 图片3\n" +
                    "虽然有人说健身保持好体脂率与美食就无缘了，对于健身健美的人来说，一个强壮的身材更有吸引力。不过想要好身材的朋友们，坚持健身控制好饮食才能更好的塑造身材，一定不要半途而废了。小编给大家推荐一组训练，不妨一起来了解一下吧。"
            , "有人拥有高颜值,有人则是傲人身材,但是两者都有的人还真是令人惊艳,两者都有的人估计也是名气不小的红人。在IG上就有不少这样的红人，健身达人们就是这样的存在，高颜值和好身材几乎是他们的标配。\n" +
            "\n" +
            "高颜值和傲人身材的标配，这位模特女神还可以更优秀 - 图片1\n" +
            "有位叫做塞西的女生在19岁凭颜值被大家熟知，没想到在24岁因为好身材再次成为人气不小的模特。所以优秀的人只会更优秀这句话还真是没说错。塞西虽然颜值高，身材好，但是她身材却有些许不如意，对于模特这个职业来说是一个非常大缺点。\n" +
            "\n" +
            "高颜值和傲人身材的标配，这位模特女神还可以更优秀 - 图片2\n" +
            "塞西却把自己的身材越练越好，让大家直接忽略了她身高的这个短板。经常健身的她，一周只要有时间就会泡在健身房，这样不仅能舒缓情绪压力，还能保持身材，简直就是一举两得。而且经常健身的人，几乎比同龄人要更年轻靓丽。\n" +
            "\n" +
            "高颜值和傲人身材的标配，这位模特女神还可以更优秀 - 图片3\n" +
            "健身的好处不用多说，想要好身材和年轻容貌的朋友就不要错过健身这个好方法。小编给大家推荐一组训练，不妨一起来了解一下吧。"};



    public static List<trainner_info> generateInfo() {
        List<trainner_info> trainner_infos = new ArrayList<>();
        Random rnd = new Random();
        for (int i = 0; i < NAME.length; i++) {
            trainner_info trainner_info = new trainner_info();
            trainner_info.setName(NAME[i]);
            trainner_info.setPhone(PHONE[i]);
            trainner_info.setSex(SEX[i]);
            trainner_info.setTid(i);
            trainner_info.setCourse(COUSE[i]);
            trainner_infos.add(trainner_info);
        }
        return trainner_infos;
    }

    public static List<tranner_article> getarticle() {
        List<tranner_article> tranner_articles = new ArrayList<>();
        Random rnd = new Random();

        for (int i = 0; i < NAME.length; i++) {
            tranner_article tranner_article = new tranner_article();
            tranner_article.setTitle(TITLE[i]);
            tranner_article.setAuthor(NAME[i]);
            tranner_article.setContent(CONTENT[i]);
            tranner_article.setTid(i);
            tranner_articles.add(tranner_article);
        }
        return tranner_articles;
    }
}