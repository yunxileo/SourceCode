import java.io.IOException;
import java.util.Iterator;
import java.util.StringTokenizer;
import org.apache.hadoop.fs.Path;
import org.apache.hadoop.io.IntWritable;
import org.apache.hadoop.io.LongWritable;
import org.apache.hadoop.io.Text;
import org.apache.hadoop.mapred.FileInputFormat;
import org.apache.hadoop.mapred.FileOutputFormat;
import org.apache.hadoop.mapred.JobClient;
import org.apache.hadoop.mapred.JobConf;
import org.apache.hadoop.mapred.MapReduceBase;
import org.apache.hadoop.mapred.Mapper;
import org.apache.hadoop.mapred.OutputCollector;
import org.apache.hadoop.mapred.Reducer;
import org.apache.hadoop.mapred.Reporter;
import org.apache.hadoop.mapred.TextInputFormat;
import org.apache.hadoop.mapred.TextOutputFormat;

public class WordCount {

    public static class Map extends MapReduceBase implements
            Mapper<LongWritable, Text, Text, IntWritable> {				//创建固定Map格式
        private final static IntWritable one = new IntWritable(1);			//创建数据1格式
        private Text word = new Text();								//设定输入格式
        public void map(LongWritable key, Text value,					//开始map程序
                OutputCollector<Text, IntWritable> output, Reporter reporter)
                throws IOException {			
            String line = value.toString();							//将传入值定义为line
            StringTokenizer tokenizer = new StringTokenizer(line);			//格式化传入值
            while (tokenizer.hasMoreTokens()) {						//开始迭代计算
                word.set(tokenizer.nextToken());						//设置输入值
                output.collect(word, one);							//写入输出值
            }
        }
    }

    public static class Reduce extends MapReduceBase implements
            Reducer<Text, IntWritable, Text, IntWritable> {			//创建固定Reduce格式
        public void reduce(Text key, Iterator<IntWritable> values,		//开始Reduce程序
                OutputCollector<Text, IntWritable> output, Reporter reporter)	
                throws IOException {
            int sum = 0;											//初始化计算器
            while (values.hasNext()) {							//开始迭代计算输入值
                sum += values.next().get();							//计数器计算
            }
            output.collect(key, new IntWritable(sum));					//创建输出结果
        }
    }

    public static void main(String[] args) throws Exception {				//开始主程序
        JobConf conf = new JobConf(WordCount.class);					//设置主程序
        conf.setJobName("wordcount");								//设置主程序名

        conf.setOutputKeyClass(Text.class);							//设置输出Key格式
        conf.setOutputValueClass(IntWritable.class);				//设置输出Vlaue格式

        conf.setMapperClass(Map.class);							//设置主Map
        conf.setCombinerClass(Reduce.class);				//设置第一次Reduce方法
        conf.setReducerClass(Reduce.class); 					//设置第主Reduce方法

        conf.setInputFormat(TextInputFormat.class);				//设置输入格式
        conf.setOutputFormat(TextOutputFormat.class);				//设置输出格式

        FileInputFormat.setInputPaths(conf, new Path(args[0]));		//设置输入文件路径
        FileOutputFormat.setOutputPath(conf, new Path(args[1]));		//设置输出路径

        JobClient.runJob(conf);								//开始主程序
    }
}
