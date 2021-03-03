package org.aikidistas.generated;

import com.google.protobuf.util.JsonFormat;
import lombok.SneakyThrows;
import org.aikidistas.generated.PersonOuterClass.Person;
import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.assertEquals;

class PersonOuterClassTest {
    @SneakyThrows
    @Test
    void name() {
        // binary
        Person me = Person.newBuilder()
                .setName("Nerijus")
                .setId(123)
                .build();
        System.out.println(me.toString());
        System.out.println(me.toByteArray().length);

        Person copy = Person.parseFrom(me.toByteArray());
        System.out.println(copy.toString());
        assertEquals("Nerijus", copy.getName());


        // json
        System.out.println("-------------------------");
        System.out.println(JsonFormat.printer().print(me));

        final Person.Builder builder = Person.newBuilder();
        JsonFormat.parser().merge(JsonFormat.printer().print(me), builder);
        System.out.println(builder.build());

        // any messages - type registry
        System.out.println("-------------------------");
        JsonFormat.TypeRegistry registry = JsonFormat.TypeRegistry.newBuilder()
                .add(Person.getDescriptor())
                .build();

//        JsonFormat.parser()
//                .usingTypeRegistry(registry)
//                .
    }


}