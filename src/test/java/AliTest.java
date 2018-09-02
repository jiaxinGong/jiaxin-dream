import java.util.ArrayList;
import java.util.Comparator;
import java.util.List;
import java.util.Map;
import java.util.Optional;
import java.util.stream.Collectors;
import sun.reflect.generics.repository.FieldRepository;

public class AliTest {

    @org.junit.Test
    public void t() {
        // 读文件
        // 合适的数据结构
        // 排序
        // 设计模式
        // 线程池
        // 并发
        List<FileRow> list = new ArrayList<>();
        list.add(new FileRow("2000102", "100", 98.3));
        list.add(new FileRow("2000103", "101", 73.3));
        list.add(new FileRow("2000105", "100", 101.3));

        Map<String, FileRow> minFileRow = list.parallelStream()
            .collect(Collectors.groupingBy(FileRow::getGroupId,
                Collectors.collectingAndThen(Collectors.minBy(Comparator.comparingDouble(FileRow::getQuota)),
                    Optional::get)));

        minFileRow.values().stream().forEach(f -> System.out.println(f));
    }

    class FileRow {

        private String id;
        private String groupId;
        private Double quota;

        public FileRow(String id, String groupId, Double quota) {
            this.id = id;
            this.groupId = groupId;
            this.quota = quota;
        }

        public String getId() {
            return id;
        }

        public void setId(String id) {
            this.id = id;
        }

        public String getGroupId() {
            return groupId;
        }

        public void setGroupId(String groupId) {
            this.groupId = groupId;
        }

        public Double getQuota() {
            return quota;
        }

        public void setQuota(Double quota) {
            this.quota = quota;
        }

        @Override
        public String toString() {
            return groupId + " " + id + " " + quota;
        }
    }
}