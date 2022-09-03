// cc YearAndTemperatureReducer Reducer for retrieve year and temperature
// vv YearAndTemperatureReducer
import java.io.IOException;

import org.apache.hadoop.io.IntWritable;
import org.apache.hadoop.io.Text;
import org.apache.hadoop.mapreduce.Reducer;

public class YearAndTemperatureReducer
  extends Reducer<Text, IntWritable, Text, IntWritable> {
  
  @Override
  public void reduce(Text key, Iterable<IntWritable> values,
      Context context)
      throws IOException, InterruptedException {
    
    int temperatureValue = 0;
    for (IntWritable value : values) {
      temperatureValue = value.get();
      context.write(key, new IntWritable(temperatureValue));
    }
  }
}
// ^^ YearAndTemperatureReducer
