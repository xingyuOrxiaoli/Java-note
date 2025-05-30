# IO流


- 按照处理的数据单元分类
  - 字节流
  - 字符流
- 按照处理对象不同
  - 节点流
  - 处理流（包装流）




## 字节流 
顶级接口 inputStream和OutputStream

###  文件流

FileInputStream和 FileOutputStream类

[使用文件流FileInputStream和FileOutputStream类实现文件的复制1:使用int变量](FileStreamTest1.java)

[使用文件流FileInputStream和FileOutputStream类实现文件的复制2:使用byte[]变量](FileStreamTest2.java)

### 缓冲流
BufferedInputStream 和 BufferedOutputStream

[使用文件流BufferedInputStream和BufferedOutputStream类实现文件的复制1:使用int变量](FileBufferStreamTest1.java)

[使用文件流BufferedInputStream和BufferedOutputStream类实现文件的复制2:使用byte[]变量](FileBufferStreamTest2.java)

### 数据流
- 只有字节流没有字符流
- 处理流 不是节点流
- 只能操作基本数据类型和字符串 
- 写入的是二进制数据，无法直接通过记事本打开
- 写入的数据需要使用对应的输入流来读取

DataInputStream和DataOutputStream

[数据流相关使用介绍代码](DataStreamTest1.java)


### 对象流
只有字节流没有字符流

ObjectInputStream和ObjectOutputStream

[对象流相关使用介绍代码](ObjectStreamTest1.java)

## 字符流
 顶级接口 Reader 和Writer

### 文件流 

FileReader 和 FileWriter

[使用文件流FileReader和FileWriter类实现文件的复制1:使用int变量](FileReaderWriterTest1.java)

[使用文件流FileReader和FileWriter类实现文件的复制2:使用char[]变量](FileReaderWriterTest1.java)

### 缓冲流
BufferedReader 和 BufferedWriter

[使用文件流BufferedReader和BufferedWriter类实现文件的复制1:使用int变量](FileBufferReaderWriterTest1.java)

[使用文件流BufferedReader和BufferedWriter类实现文件的复制2:使用char[]变量](FileBufferReaderWriterTest2.java)

[使用文件流BufferedReader和BufferedWriter类实现文件的复制3:按行复制](FileBufferReaderWriterTest3.java)


## 缓冲流一些细节

- 何时将输出缓存区的内容存储硬盘
  - 输出的缓存区满，自动写入硬盘(自动刷新flush)
  - close流的时候会先刷新
  - 手动flush()函数
- 缓冲


## 序列化

- 序列化Serialization    : 将对象的状态信息转换可以存储或传输的形式
- 过程                   : 对象(内存) --> 字节数组 字节序列化(外存,网络)
- 反序列化DeSerialization : 字节数组、字节序列(外存，网络) ---> 对象(内存) 

