# Profiling

## Базовое задание ("3"-"4")

Проанализируйте приложение с использованием Java VisualVM (jvisualvm.exe)

 * Скачайте [приложение](lab3.jar) для Лаб №2 (Декопиляция).
 * Запустите Java VisualVM (входит в состав JDK), установите плагин Visual GC _можно найти c:\Program Files\Java\jdk1.7.0_79\bin\jvisualvm.exe_
 * Составьте отчет.

### Состав отчета

 * Запустите приложение lab3.jar: `java -jar lab3.jar`
 * Cколько потоков использует приложение? Как вы это узнали? Cкриншот! (Вкладка Monitor)
 * Какие методы сейчас выполняют эти потоки? (Вкладка Monitor->Heap Dump)
 * Много ли создается короткоживущих объектов (Eden Space), они удаляются или переходят в старое поколение? Как часто запускается уборка мусора? Как вы это узнали? Cкриншот! (Вкладка Visual GC)
 * Какого типа объекты создаются? (Sampler->Memory). Выполнение каких методов занимает много времени? (Sampler->Memory) Как вы это узнали? Cкриншот!
 * Что изменится, если запустить приложение с параметром -Xmx10m. Что задает этот параметр?
 * Что изменится, если запустить приложение с параметром -XX:+UseG1GC. Что задает этот параметр?

## Расширенное задание ("4"-"5")

Проанализируйте приложение с использованием JProfiler

 * Напишите отчет для базового задания
 * Запустите [Jprofiler](​http://www.ej-technologies.com/products/jprofiler/overview.html). Изучите вопросы сформулированные ниже. Напишите свое мнение в отчете. Отчет прикрепите к заданию.
 * Исследуйте приложение в режимах Instrumantation и Sampling. В чем отличия режимов? Заметны ли они на тестовом приложении.
 * Исследуйте, какой метод занимает больше всего времени CPU (Hot Spots).
 * Проанализируйте метод doDrawing (режим Instrumantation в Jprofiler):

 ```java
    private void doDrawing(Graphics g) {
        ...
  	    ShapeFactory shape;
          ** shape = new ShapeFactory(this.shape); **
        ...
         while (j < h) {
            int i = shape.width;
            while (i < w) {
                angle = angle > 360.0 ? 0.0 : angle + dr;
                AffineTransform transform = new AffineTransform();
                transform.translate(i, j);
                ** transform.rotate(Math.toRadians(angle)); **
                this.g2d.draw(transform.createTransformedShape(shape.shape));
                i = (int)((double)i + (double)shape.width * 1.5);
            }
            j = (int)((double)j + (double)shape.height * 1.5);
        }
        this.is_done = true;
    }
```

 1. При каждом вызове метода генерируется новая фигура. Фигура не меняется. Возможно ее достаточно создать 1 раз? Целесообразно ли это? Объясните ответ.
 2. Для каждой из фигур выполняется аффинное преобразование - вращение. Это умножение на матрицу из синусов и косинусов. Будет ли выигрыш, если заранее подготовить массив фигур, повернутых на нужны угол. Целесообразно ли это? Объясните ответ.


## Notes

 > `-Xmxn`
 >
 > Specifies the maximum size, in bytes, of the memory allocation pool. This value must a multiple of 1024 greater than 2 MB. Append the letter k or K to indicate kilobytes, or m or M to indicate megabytes. The default value is chosen at runtime based on system configuration.

Значит `-Xmx10m` задает максимальный размер выделяемой памяти 10 Мб

 > `-XX:+UseG1GC`
 >
 > Enables the G1 garbage collectors.
