package sun.util.calendar;

import java.util.TimeZone;
import sun.util.calendar.BaseCalendar;

/*  JADX ERROR: NullPointerException in pass: ClassModifier
    java.lang.NullPointerException
    */
/*  JADX ERROR: NullPointerException in pass: ExtractFieldInit
    java.lang.NullPointerException
    	at jadx.core.utils.BlockUtils.isAllBlocksEmpty(BlockUtils.java:564)
    	at jadx.core.dex.visitors.ExtractFieldInit.getConstructorsList(ExtractFieldInit.java:245)
    	at jadx.core.dex.visitors.ExtractFieldInit.moveCommonFieldsInit(ExtractFieldInit.java:126)
    	at jadx.core.dex.visitors.ExtractFieldInit.visit(ExtractFieldInit.java:46)
    	at jadx.core.dex.visitors.ExtractFieldInit.visit(ExtractFieldInit.java:42)
    */
public class LocalGregorianCalendar extends BaseCalendar {
    private Era[] eras;
    private String name;

    public static class Date extends BaseCalendar.Date {
        private int gregorianYear;

        /*  JADX ERROR: Method load error
            jadx.core.utils.exceptions.DecodeException: Load method exception: bogus opcode: 00e6 in method: sun.util.calendar.LocalGregorianCalendar.Date.<init>():void, dex: classes.dex
            	at jadx.core.dex.nodes.MethodNode.load(MethodNode.java:151)
            	at jadx.core.dex.nodes.ClassNode.load(ClassNode.java:286)
            	at jadx.core.dex.nodes.ClassNode.load(ClassNode.java:292)
            	at jadx.core.ProcessClass.process(ProcessClass.java:36)
            	at java.util.ArrayList.forEach(ArrayList.java:1259)
            	at jadx.core.ProcessClass.generateCode(ProcessClass.java:59)
            	at jadx.core.dex.nodes.ClassNode.decompile(ClassNode.java:273)
            Caused by: java.lang.IllegalArgumentException: bogus opcode: 00e6
            	at com.android.dx.io.OpcodeInfo.get(OpcodeInfo.java:1227)
            	at com.android.dx.io.OpcodeInfo.getName(OpcodeInfo.java:1234)
            	at jadx.core.dex.instructions.InsnDecoder.decode(InsnDecoder.java:588)
            	at jadx.core.dex.instructions.InsnDecoder.process(InsnDecoder.java:78)
            	at jadx.core.dex.nodes.MethodNode.load(MethodNode.java:136)
            	... 6 more
            */
        protected Date() {
            /*
            // Can't load method instructions: Load method exception: bogus opcode: 00e6 in method: sun.util.calendar.LocalGregorianCalendar.Date.<init>():void, dex: classes.dex
            */
            throw new UnsupportedOperationException("Method not decompiled: sun.util.calendar.LocalGregorianCalendar.Date.<init>():void");
        }

        /*  JADX ERROR: Method load error
            jadx.core.utils.exceptions.DecodeException: Load method exception: bogus opcode: 00e6 in method: sun.util.calendar.LocalGregorianCalendar.Date.<init>(java.util.TimeZone):void, dex: classes.dex
            	at jadx.core.dex.nodes.MethodNode.load(MethodNode.java:151)
            	at jadx.core.dex.nodes.ClassNode.load(ClassNode.java:286)
            	at jadx.core.dex.nodes.ClassNode.load(ClassNode.java:292)
            	at jadx.core.ProcessClass.process(ProcessClass.java:36)
            	at java.util.ArrayList.forEach(ArrayList.java:1259)
            	at jadx.core.ProcessClass.generateCode(ProcessClass.java:59)
            	at jadx.core.dex.nodes.ClassNode.decompile(ClassNode.java:273)
            Caused by: java.lang.IllegalArgumentException: bogus opcode: 00e6
            	at com.android.dx.io.OpcodeInfo.get(OpcodeInfo.java:1227)
            	at com.android.dx.io.OpcodeInfo.getName(OpcodeInfo.java:1234)
            	at jadx.core.dex.instructions.InsnDecoder.decode(InsnDecoder.java:588)
            	at jadx.core.dex.instructions.InsnDecoder.process(InsnDecoder.java:78)
            	at jadx.core.dex.nodes.MethodNode.load(MethodNode.java:136)
            	... 6 more
            */
        protected Date(java.util.TimeZone r1) {
            /*
            // Can't load method instructions: Load method exception: bogus opcode: 00e6 in method: sun.util.calendar.LocalGregorianCalendar.Date.<init>(java.util.TimeZone):void, dex: classes.dex
            */
            throw new UnsupportedOperationException("Method not decompiled: sun.util.calendar.LocalGregorianCalendar.Date.<init>(java.util.TimeZone):void");
        }

        /*  JADX ERROR: Method load error
            jadx.core.utils.exceptions.DecodeException: Load method exception: bogus opcode: 00e9 in method: sun.util.calendar.LocalGregorianCalendar.Date.addYear(int):sun.util.calendar.CalendarDate, dex: classes.dex
            	at jadx.core.dex.nodes.MethodNode.load(MethodNode.java:151)
            	at jadx.core.dex.nodes.ClassNode.load(ClassNode.java:286)
            	at jadx.core.dex.nodes.ClassNode.load(ClassNode.java:292)
            	at jadx.core.ProcessClass.process(ProcessClass.java:36)
            	at java.util.ArrayList.forEach(ArrayList.java:1259)
            	at jadx.core.ProcessClass.generateCode(ProcessClass.java:59)
            	at jadx.core.dex.nodes.ClassNode.decompile(ClassNode.java:273)
            Caused by: java.lang.IllegalArgumentException: bogus opcode: 00e9
            	at com.android.dx.io.OpcodeInfo.get(OpcodeInfo.java:1227)
            	at com.android.dx.io.OpcodeInfo.getName(OpcodeInfo.java:1234)
            	at jadx.core.dex.instructions.InsnDecoder.decode(InsnDecoder.java:588)
            	at jadx.core.dex.instructions.InsnDecoder.process(InsnDecoder.java:78)
            	at jadx.core.dex.nodes.MethodNode.load(MethodNode.java:136)
            	... 6 more
            */
        public /* bridge */ /* synthetic */ sun.util.calendar.CalendarDate addYear(int r1) {
            /*
            // Can't load method instructions: Load method exception: bogus opcode: 00e9 in method: sun.util.calendar.LocalGregorianCalendar.Date.addYear(int):sun.util.calendar.CalendarDate, dex: classes.dex
            */
            throw new UnsupportedOperationException("Method not decompiled: sun.util.calendar.LocalGregorianCalendar.Date.addYear(int):sun.util.calendar.CalendarDate");
        }

        /*  JADX ERROR: Method load error
            jadx.core.utils.exceptions.DecodeException: Load method exception: bogus opcode: 00e3 in method: sun.util.calendar.LocalGregorianCalendar.Date.addYear(int):sun.util.calendar.LocalGregorianCalendar$Date, dex: classes.dex
            	at jadx.core.dex.nodes.MethodNode.load(MethodNode.java:151)
            	at jadx.core.dex.nodes.ClassNode.load(ClassNode.java:286)
            	at jadx.core.dex.nodes.ClassNode.load(ClassNode.java:292)
            	at jadx.core.ProcessClass.process(ProcessClass.java:36)
            	at java.util.ArrayList.forEach(ArrayList.java:1259)
            	at jadx.core.ProcessClass.generateCode(ProcessClass.java:59)
            	at jadx.core.dex.nodes.ClassNode.decompile(ClassNode.java:273)
            Caused by: java.lang.IllegalArgumentException: bogus opcode: 00e3
            	at com.android.dx.io.OpcodeInfo.get(OpcodeInfo.java:1227)
            	at com.android.dx.io.OpcodeInfo.getName(OpcodeInfo.java:1234)
            	at jadx.core.dex.instructions.InsnDecoder.decode(InsnDecoder.java:588)
            	at jadx.core.dex.instructions.InsnDecoder.process(InsnDecoder.java:78)
            	at jadx.core.dex.nodes.MethodNode.load(MethodNode.java:136)
            	... 6 more
            */
        public sun.util.calendar.LocalGregorianCalendar.Date addYear(int r1) {
            /*
            // Can't load method instructions: Load method exception: bogus opcode: 00e3 in method: sun.util.calendar.LocalGregorianCalendar.Date.addYear(int):sun.util.calendar.LocalGregorianCalendar$Date, dex: classes.dex
            */
            throw new UnsupportedOperationException("Method not decompiled: sun.util.calendar.LocalGregorianCalendar.Date.addYear(int):sun.util.calendar.LocalGregorianCalendar$Date");
        }

        /*  JADX ERROR: Method load error
            jadx.core.utils.exceptions.DecodeException: Load method exception: bogus opcode: 00e3 in method: sun.util.calendar.LocalGregorianCalendar.Date.getNormalizedYear():int, dex: classes.dex
            	at jadx.core.dex.nodes.MethodNode.load(MethodNode.java:151)
            	at jadx.core.dex.nodes.ClassNode.load(ClassNode.java:286)
            	at jadx.core.dex.nodes.ClassNode.load(ClassNode.java:292)
            	at jadx.core.ProcessClass.process(ProcessClass.java:36)
            	at java.util.ArrayList.forEach(ArrayList.java:1259)
            	at jadx.core.ProcessClass.generateCode(ProcessClass.java:59)
            	at jadx.core.dex.nodes.ClassNode.decompile(ClassNode.java:273)
            Caused by: java.lang.IllegalArgumentException: bogus opcode: 00e3
            	at com.android.dx.io.OpcodeInfo.get(OpcodeInfo.java:1227)
            	at com.android.dx.io.OpcodeInfo.getName(OpcodeInfo.java:1234)
            	at jadx.core.dex.instructions.InsnDecoder.decode(InsnDecoder.java:588)
            	at jadx.core.dex.instructions.InsnDecoder.process(InsnDecoder.java:78)
            	at jadx.core.dex.nodes.MethodNode.load(MethodNode.java:136)
            	... 6 more
            */
        public int getNormalizedYear() {
            /*
            // Can't load method instructions: Load method exception: bogus opcode: 00e3 in method: sun.util.calendar.LocalGregorianCalendar.Date.getNormalizedYear():int, dex: classes.dex
            */
            throw new UnsupportedOperationException("Method not decompiled: sun.util.calendar.LocalGregorianCalendar.Date.getNormalizedYear():int");
        }

        /*  JADX ERROR: Method load error
            jadx.core.utils.exceptions.DecodeException: Load method exception: bogus opcode: 00e9 in method: sun.util.calendar.LocalGregorianCalendar.Date.setEra(sun.util.calendar.Era):sun.util.calendar.CalendarDate, dex: classes.dex
            	at jadx.core.dex.nodes.MethodNode.load(MethodNode.java:151)
            	at jadx.core.dex.nodes.ClassNode.load(ClassNode.java:286)
            	at jadx.core.dex.nodes.ClassNode.load(ClassNode.java:292)
            	at jadx.core.ProcessClass.process(ProcessClass.java:36)
            	at java.util.ArrayList.forEach(ArrayList.java:1259)
            	at jadx.core.ProcessClass.generateCode(ProcessClass.java:59)
            	at jadx.core.dex.nodes.ClassNode.decompile(ClassNode.java:273)
            Caused by: java.lang.IllegalArgumentException: bogus opcode: 00e9
            	at com.android.dx.io.OpcodeInfo.get(OpcodeInfo.java:1227)
            	at com.android.dx.io.OpcodeInfo.getName(OpcodeInfo.java:1234)
            	at jadx.core.dex.instructions.InsnDecoder.decode(InsnDecoder.java:588)
            	at jadx.core.dex.instructions.InsnDecoder.process(InsnDecoder.java:78)
            	at jadx.core.dex.nodes.MethodNode.load(MethodNode.java:136)
            	... 6 more
            */
        public /* bridge */ /* synthetic */ sun.util.calendar.CalendarDate setEra(sun.util.calendar.Era r1) {
            /*
            // Can't load method instructions: Load method exception: bogus opcode: 00e9 in method: sun.util.calendar.LocalGregorianCalendar.Date.setEra(sun.util.calendar.Era):sun.util.calendar.CalendarDate, dex: classes.dex
            */
            throw new UnsupportedOperationException("Method not decompiled: sun.util.calendar.LocalGregorianCalendar.Date.setEra(sun.util.calendar.Era):sun.util.calendar.CalendarDate");
        }

        /*  JADX ERROR: Method load error
            jadx.core.utils.exceptions.DecodeException: Load method exception: bogus opcode: 00e9 in method: sun.util.calendar.LocalGregorianCalendar.Date.setEra(sun.util.calendar.Era):sun.util.calendar.LocalGregorianCalendar$Date, dex: classes.dex
            	at jadx.core.dex.nodes.MethodNode.load(MethodNode.java:151)
            	at jadx.core.dex.nodes.ClassNode.load(ClassNode.java:286)
            	at jadx.core.dex.nodes.ClassNode.load(ClassNode.java:292)
            	at jadx.core.ProcessClass.process(ProcessClass.java:36)
            	at java.util.ArrayList.forEach(ArrayList.java:1259)
            	at jadx.core.ProcessClass.generateCode(ProcessClass.java:59)
            	at jadx.core.dex.nodes.ClassNode.decompile(ClassNode.java:273)
            Caused by: java.lang.IllegalArgumentException: bogus opcode: 00e9
            	at com.android.dx.io.OpcodeInfo.get(OpcodeInfo.java:1227)
            	at com.android.dx.io.OpcodeInfo.getName(OpcodeInfo.java:1234)
            	at jadx.core.dex.instructions.InsnDecoder.decode(InsnDecoder.java:588)
            	at jadx.core.dex.instructions.InsnDecoder.process(InsnDecoder.java:78)
            	at jadx.core.dex.nodes.MethodNode.load(MethodNode.java:136)
            	... 6 more
            */
        public sun.util.calendar.LocalGregorianCalendar.Date setEra(sun.util.calendar.Era r1) {
            /*
            // Can't load method instructions: Load method exception: bogus opcode: 00e9 in method: sun.util.calendar.LocalGregorianCalendar.Date.setEra(sun.util.calendar.Era):sun.util.calendar.LocalGregorianCalendar$Date, dex: classes.dex
            */
            throw new UnsupportedOperationException("Method not decompiled: sun.util.calendar.LocalGregorianCalendar.Date.setEra(sun.util.calendar.Era):sun.util.calendar.LocalGregorianCalendar$Date");
        }

        /*  JADX ERROR: Method load error
            jadx.core.utils.exceptions.DecodeException: Load method exception: bogus opcode: 0073 in method: sun.util.calendar.LocalGregorianCalendar.Date.setLocalEra(sun.util.calendar.Era):void, dex: classes.dex
            	at jadx.core.dex.nodes.MethodNode.load(MethodNode.java:151)
            	at jadx.core.dex.nodes.ClassNode.load(ClassNode.java:286)
            	at jadx.core.dex.nodes.ClassNode.load(ClassNode.java:292)
            	at jadx.core.ProcessClass.process(ProcessClass.java:36)
            	at java.util.ArrayList.forEach(ArrayList.java:1259)
            	at jadx.core.ProcessClass.generateCode(ProcessClass.java:59)
            	at jadx.core.dex.nodes.ClassNode.decompile(ClassNode.java:273)
            Caused by: java.lang.IllegalArgumentException: bogus opcode: 0073
            	at com.android.dx.io.OpcodeInfo.get(OpcodeInfo.java:1227)
            	at com.android.dx.io.OpcodeInfo.getName(OpcodeInfo.java:1234)
            	at jadx.core.dex.instructions.InsnDecoder.decode(InsnDecoder.java:588)
            	at jadx.core.dex.instructions.InsnDecoder.process(InsnDecoder.java:78)
            	at jadx.core.dex.nodes.MethodNode.load(MethodNode.java:136)
            	... 6 more
            */
        void setLocalEra(sun.util.calendar.Era r1) {
            /*
            // Can't load method instructions: Load method exception: bogus opcode: 0073 in method: sun.util.calendar.LocalGregorianCalendar.Date.setLocalEra(sun.util.calendar.Era):void, dex: classes.dex
            */
            throw new UnsupportedOperationException("Method not decompiled: sun.util.calendar.LocalGregorianCalendar.Date.setLocalEra(sun.util.calendar.Era):void");
        }

        /*  JADX ERROR: Method load error
            jadx.core.utils.exceptions.DecodeException: Load method exception: bogus opcode: 0073 in method: sun.util.calendar.LocalGregorianCalendar.Date.setLocalYear(int):void, dex: classes.dex
            	at jadx.core.dex.nodes.MethodNode.load(MethodNode.java:151)
            	at jadx.core.dex.nodes.ClassNode.load(ClassNode.java:286)
            	at jadx.core.dex.nodes.ClassNode.load(ClassNode.java:292)
            	at jadx.core.ProcessClass.process(ProcessClass.java:36)
            	at java.util.ArrayList.forEach(ArrayList.java:1259)
            	at jadx.core.ProcessClass.generateCode(ProcessClass.java:59)
            	at jadx.core.dex.nodes.ClassNode.decompile(ClassNode.java:273)
            Caused by: java.lang.IllegalArgumentException: bogus opcode: 0073
            	at com.android.dx.io.OpcodeInfo.get(OpcodeInfo.java:1227)
            	at com.android.dx.io.OpcodeInfo.getName(OpcodeInfo.java:1234)
            	at jadx.core.dex.instructions.InsnDecoder.decode(InsnDecoder.java:588)
            	at jadx.core.dex.instructions.InsnDecoder.process(InsnDecoder.java:78)
            	at jadx.core.dex.nodes.MethodNode.load(MethodNode.java:136)
            	... 6 more
            */
        void setLocalYear(int r1) {
            /*
            // Can't load method instructions: Load method exception: bogus opcode: 0073 in method: sun.util.calendar.LocalGregorianCalendar.Date.setLocalYear(int):void, dex: classes.dex
            */
            throw new UnsupportedOperationException("Method not decompiled: sun.util.calendar.LocalGregorianCalendar.Date.setLocalYear(int):void");
        }

        /*  JADX ERROR: Method load error
            jadx.core.utils.exceptions.DecodeException: Load method exception: bogus opcode: 00e6 in method: sun.util.calendar.LocalGregorianCalendar.Date.setNormalizedYear(int):void, dex: classes.dex
            	at jadx.core.dex.nodes.MethodNode.load(MethodNode.java:151)
            	at jadx.core.dex.nodes.ClassNode.load(ClassNode.java:286)
            	at jadx.core.dex.nodes.ClassNode.load(ClassNode.java:292)
            	at jadx.core.ProcessClass.process(ProcessClass.java:36)
            	at java.util.ArrayList.forEach(ArrayList.java:1259)
            	at jadx.core.ProcessClass.generateCode(ProcessClass.java:59)
            	at jadx.core.dex.nodes.ClassNode.decompile(ClassNode.java:273)
            Caused by: java.lang.IllegalArgumentException: bogus opcode: 00e6
            	at com.android.dx.io.OpcodeInfo.get(OpcodeInfo.java:1227)
            	at com.android.dx.io.OpcodeInfo.getName(OpcodeInfo.java:1234)
            	at jadx.core.dex.instructions.InsnDecoder.decode(InsnDecoder.java:588)
            	at jadx.core.dex.instructions.InsnDecoder.process(InsnDecoder.java:78)
            	at jadx.core.dex.nodes.MethodNode.load(MethodNode.java:136)
            	... 6 more
            */
        public void setNormalizedYear(int r1) {
            /*
            // Can't load method instructions: Load method exception: bogus opcode: 00e6 in method: sun.util.calendar.LocalGregorianCalendar.Date.setNormalizedYear(int):void, dex: classes.dex
            */
            throw new UnsupportedOperationException("Method not decompiled: sun.util.calendar.LocalGregorianCalendar.Date.setNormalizedYear(int):void");
        }

        /*  JADX ERROR: Method load error
            jadx.core.utils.exceptions.DecodeException: Load method exception: bogus opcode: 00e9 in method: sun.util.calendar.LocalGregorianCalendar.Date.setYear(int):sun.util.calendar.CalendarDate, dex: classes.dex
            	at jadx.core.dex.nodes.MethodNode.load(MethodNode.java:151)
            	at jadx.core.dex.nodes.ClassNode.load(ClassNode.java:286)
            	at jadx.core.dex.nodes.ClassNode.load(ClassNode.java:292)
            	at jadx.core.ProcessClass.process(ProcessClass.java:36)
            	at java.util.ArrayList.forEach(ArrayList.java:1259)
            	at jadx.core.ProcessClass.generateCode(ProcessClass.java:59)
            	at jadx.core.dex.nodes.ClassNode.decompile(ClassNode.java:273)
            Caused by: java.lang.IllegalArgumentException: bogus opcode: 00e9
            	at com.android.dx.io.OpcodeInfo.get(OpcodeInfo.java:1227)
            	at com.android.dx.io.OpcodeInfo.getName(OpcodeInfo.java:1234)
            	at jadx.core.dex.instructions.InsnDecoder.decode(InsnDecoder.java:588)
            	at jadx.core.dex.instructions.InsnDecoder.process(InsnDecoder.java:78)
            	at jadx.core.dex.nodes.MethodNode.load(MethodNode.java:136)
            	... 6 more
            */
        public /* bridge */ /* synthetic */ sun.util.calendar.CalendarDate setYear(int r1) {
            /*
            // Can't load method instructions: Load method exception: bogus opcode: 00e9 in method: sun.util.calendar.LocalGregorianCalendar.Date.setYear(int):sun.util.calendar.CalendarDate, dex: classes.dex
            */
            throw new UnsupportedOperationException("Method not decompiled: sun.util.calendar.LocalGregorianCalendar.Date.setYear(int):sun.util.calendar.CalendarDate");
        }

        /*  JADX ERROR: Method load error
            jadx.core.utils.exceptions.DecodeException: Load method exception: bogus opcode: 00e9 in method: sun.util.calendar.LocalGregorianCalendar.Date.setYear(int):sun.util.calendar.LocalGregorianCalendar$Date, dex: classes.dex
            	at jadx.core.dex.nodes.MethodNode.load(MethodNode.java:151)
            	at jadx.core.dex.nodes.ClassNode.load(ClassNode.java:286)
            	at jadx.core.dex.nodes.ClassNode.load(ClassNode.java:292)
            	at jadx.core.ProcessClass.process(ProcessClass.java:36)
            	at java.util.ArrayList.forEach(ArrayList.java:1259)
            	at jadx.core.ProcessClass.generateCode(ProcessClass.java:59)
            	at jadx.core.dex.nodes.ClassNode.decompile(ClassNode.java:273)
            Caused by: java.lang.IllegalArgumentException: bogus opcode: 00e9
            	at com.android.dx.io.OpcodeInfo.get(OpcodeInfo.java:1227)
            	at com.android.dx.io.OpcodeInfo.getName(OpcodeInfo.java:1234)
            	at jadx.core.dex.instructions.InsnDecoder.decode(InsnDecoder.java:588)
            	at jadx.core.dex.instructions.InsnDecoder.process(InsnDecoder.java:78)
            	at jadx.core.dex.nodes.MethodNode.load(MethodNode.java:136)
            	... 6 more
            */
        public sun.util.calendar.LocalGregorianCalendar.Date setYear(int r1) {
            /*
            // Can't load method instructions: Load method exception: bogus opcode: 00e9 in method: sun.util.calendar.LocalGregorianCalendar.Date.setYear(int):sun.util.calendar.LocalGregorianCalendar$Date, dex: classes.dex
            */
            throw new UnsupportedOperationException("Method not decompiled: sun.util.calendar.LocalGregorianCalendar.Date.setYear(int):sun.util.calendar.LocalGregorianCalendar$Date");
        }

        /*  JADX ERROR: Method load error
            jadx.core.utils.exceptions.DecodeException: Load method exception: bogus opcode: 00e9 in method: sun.util.calendar.LocalGregorianCalendar.Date.toString():java.lang.String, dex: classes.dex
            	at jadx.core.dex.nodes.MethodNode.load(MethodNode.java:151)
            	at jadx.core.dex.nodes.ClassNode.load(ClassNode.java:286)
            	at jadx.core.dex.nodes.ClassNode.load(ClassNode.java:292)
            	at jadx.core.ProcessClass.process(ProcessClass.java:36)
            	at java.util.ArrayList.forEach(ArrayList.java:1259)
            	at jadx.core.ProcessClass.generateCode(ProcessClass.java:59)
            	at jadx.core.dex.nodes.ClassNode.decompile(ClassNode.java:273)
            Caused by: java.lang.IllegalArgumentException: bogus opcode: 00e9
            	at com.android.dx.io.OpcodeInfo.get(OpcodeInfo.java:1227)
            	at com.android.dx.io.OpcodeInfo.getName(OpcodeInfo.java:1234)
            	at jadx.core.dex.instructions.InsnDecoder.decode(InsnDecoder.java:588)
            	at jadx.core.dex.instructions.InsnDecoder.process(InsnDecoder.java:78)
            	at jadx.core.dex.nodes.MethodNode.load(MethodNode.java:136)
            	... 6 more
            */
        public java.lang.String toString() {
            /*
            // Can't load method instructions: Load method exception: bogus opcode: 00e9 in method: sun.util.calendar.LocalGregorianCalendar.Date.toString():java.lang.String, dex: classes.dex
            */
            throw new UnsupportedOperationException("Method not decompiled: sun.util.calendar.LocalGregorianCalendar.Date.toString():java.lang.String");
        }
    }

    /*  JADX ERROR: NullPointerException in pass: ModVisitor
        java.lang.NullPointerException
        	at jadx.core.dex.visitors.ModVisitor.getParentInsnSkipMove(ModVisitor.java:344)
        	at jadx.core.dex.visitors.ModVisitor.getArgsToFieldsMapping(ModVisitor.java:318)
        	at jadx.core.dex.visitors.ModVisitor.processAnonymousConstructor(ModVisitor.java:280)
        	at jadx.core.dex.visitors.ModVisitor.replaceStep(ModVisitor.java:91)
        	at jadx.core.dex.visitors.ModVisitor.visit(ModVisitor.java:77)
        */
    static sun.util.calendar.LocalGregorianCalendar getLocalGregorianCalendar(java.lang.String r27) {
        /*
            r4 = 0
            sun.security.action.GetPropertyAction r24 = new sun.security.action.GetPropertyAction     // Catch:{ PrivilegedActionException -> 0x0071 }
            java.lang.String r25 = "java.home"
            r24.<init>(r25)     // Catch:{ PrivilegedActionException -> 0x0071 }
            java.lang.Object r16 = java.security.AccessController.doPrivileged(r24)     // Catch:{ PrivilegedActionException -> 0x0071 }
            java.lang.String r16 = (java.lang.String) r16     // Catch:{ PrivilegedActionException -> 0x0071 }
            java.lang.StringBuilder r24 = new java.lang.StringBuilder     // Catch:{ PrivilegedActionException -> 0x0071 }
            r24.<init>()     // Catch:{ PrivilegedActionException -> 0x0071 }
            r0 = r24
            r1 = r16
            java.lang.StringBuilder r24 = r0.append((java.lang.String) r1)     // Catch:{ PrivilegedActionException -> 0x0071 }
            java.lang.String r25 = java.io.File.separator     // Catch:{ PrivilegedActionException -> 0x0071 }
            java.lang.StringBuilder r24 = r24.append((java.lang.String) r25)     // Catch:{ PrivilegedActionException -> 0x0071 }
            java.lang.String r25 = "lib"
            java.lang.StringBuilder r24 = r24.append((java.lang.String) r25)     // Catch:{ PrivilegedActionException -> 0x0071 }
            java.lang.String r25 = java.io.File.separator     // Catch:{ PrivilegedActionException -> 0x0071 }
            java.lang.StringBuilder r24 = r24.append((java.lang.String) r25)     // Catch:{ PrivilegedActionException -> 0x0071 }
            java.lang.String r25 = "calendars.properties"
            java.lang.StringBuilder r24 = r24.append((java.lang.String) r25)     // Catch:{ PrivilegedActionException -> 0x0071 }
            java.lang.String r15 = r24.toString()     // Catch:{ PrivilegedActionException -> 0x0071 }
            sun.util.calendar.LocalGregorianCalendar$1 r24 = new sun.util.calendar.LocalGregorianCalendar$1     // Catch:{ PrivilegedActionException -> 0x0071 }
            r0 = r24
            r0.<init>(r15)     // Catch:{ PrivilegedActionException -> 0x0071 }
            java.lang.Object r4 = java.security.AccessController.doPrivileged(r24)     // Catch:{ PrivilegedActionException -> 0x0071 }
            java.util.Properties r4 = (java.util.Properties) r4     // Catch:{ PrivilegedActionException -> 0x0071 }
            java.lang.StringBuilder r24 = new java.lang.StringBuilder
            r24.<init>()
            java.lang.String r25 = "calendar."
            java.lang.StringBuilder r24 = r24.append((java.lang.String) r25)
            r0 = r24
            r1 = r27
            java.lang.StringBuilder r24 = r0.append((java.lang.String) r1)
            java.lang.String r25 = ".eras"
            java.lang.StringBuilder r24 = r24.append((java.lang.String) r25)
            java.lang.String r24 = r24.toString()
            r0 = r24
            java.lang.String r22 = r4.getProperty(r0)
            if (r22 != 0) goto L_0x007c
            r24 = 0
            return r24
        L_0x0071:
            r11 = move-exception
            java.lang.RuntimeException r24 = new java.lang.RuntimeException
            java.lang.Exception r25 = r11.getException()
            r24.<init>((java.lang.Throwable) r25)
            throw r24
        L_0x007c:
            java.util.ArrayList r14 = new java.util.ArrayList
            r14.<init>()
            java.util.StringTokenizer r13 = new java.util.StringTokenizer
            java.lang.String r24 = ";"
            r0 = r22
            r1 = r24
            r13.<init>(r0, r1)
        L_0x008d:
            boolean r24 = r13.hasMoreTokens()
            if (r24 == 0) goto L_0x015f
            java.lang.String r24 = r13.nextToken()
            java.lang.String r20 = r24.trim()
            java.util.StringTokenizer r19 = new java.util.StringTokenizer
            java.lang.String r24 = ","
            r0 = r19
            r1 = r20
            r2 = r24
            r0.<init>(r1, r2)
            r6 = 0
            r10 = 1
            r8 = 0
            r7 = 0
        L_0x00ae:
            boolean r24 = r19.hasMoreTokens()
            if (r24 == 0) goto L_0x0155
            java.lang.String r18 = r19.nextToken()
            r24 = 61
            r0 = r18
            r1 = r24
            int r17 = r0.indexOf((int) r1)
            r24 = -1
            r0 = r17
            r1 = r24
            if (r0 != r1) goto L_0x00cd
            r24 = 0
            return r24
        L_0x00cd:
            r24 = 0
            r0 = r18
            r1 = r24
            r2 = r17
            java.lang.String r21 = r0.substring(r1, r2)
            int r24 = r17 + 1
            r0 = r18
            r1 = r24
            java.lang.String r23 = r0.substring(r1)
            java.lang.String r24 = "name"
            r0 = r24
            r1 = r21
            boolean r24 = r0.equals(r1)
            if (r24 == 0) goto L_0x00f3
            r6 = r23
            goto L_0x00ae
        L_0x00f3:
            java.lang.String r24 = "since"
            r0 = r24
            r1 = r21
            boolean r24 = r0.equals(r1)
            if (r24 == 0) goto L_0x0126
            java.lang.String r24 = "u"
            boolean r24 = r23.endsWith(r24)
            if (r24 == 0) goto L_0x0121
            r10 = 0
            int r24 = r23.length()
            int r24 = r24 + -1
            r25 = 0
            r0 = r23
            r1 = r25
            r2 = r24
            java.lang.String r24 = r0.substring(r1, r2)
            long r8 = java.lang.Long.parseLong(r24)
            goto L_0x00ae
        L_0x0121:
            long r8 = java.lang.Long.parseLong(r23)
            goto L_0x00ae
        L_0x0126:
            java.lang.String r24 = "abbr"
            r0 = r24
            r1 = r21
            boolean r24 = r0.equals(r1)
            if (r24 == 0) goto L_0x0137
            r7 = r23
            goto L_0x00ae
        L_0x0137:
            java.lang.RuntimeException r24 = new java.lang.RuntimeException
            java.lang.StringBuilder r25 = new java.lang.StringBuilder
            r25.<init>()
            java.lang.String r26 = "Unknown key word: "
            java.lang.StringBuilder r25 = r25.append((java.lang.String) r26)
            r0 = r25
            r1 = r21
            java.lang.StringBuilder r25 = r0.append((java.lang.String) r1)
            java.lang.String r25 = r25.toString()
            r24.<init>((java.lang.String) r25)
            throw r24
        L_0x0155:
            sun.util.calendar.Era r5 = new sun.util.calendar.Era
            r5.<init>(r6, r7, r8, r10)
            r14.add(r5)
            goto L_0x008d
        L_0x015f:
            int r24 = r14.size()
            r0 = r24
            sun.util.calendar.Era[] r12 = new sun.util.calendar.Era[r0]
            r14.toArray(r12)
            sun.util.calendar.LocalGregorianCalendar r24 = new sun.util.calendar.LocalGregorianCalendar
            r0 = r24
            r1 = r27
            r0.<init>(r1, r12)
            return r24
        */
        throw new UnsupportedOperationException("Method not decompiled: sun.util.calendar.LocalGregorianCalendar.getLocalGregorianCalendar(java.lang.String):sun.util.calendar.LocalGregorianCalendar");
    }

    private LocalGregorianCalendar(String name2, Era[] eras2) {
        this.name = name2;
        this.eras = eras2;
        setEras(eras2);
    }

    public String getName() {
        return this.name;
    }

    public /* bridge */ /* synthetic */ CalendarDate getCalendarDate() {
        return getCalendarDate();
    }

    public Date getCalendarDate() {
        return getCalendarDate(System.currentTimeMillis(), (CalendarDate) newCalendarDate());
    }

    public /* bridge */ /* synthetic */ CalendarDate getCalendarDate(long millis) {
        return getCalendarDate(millis);
    }

    public Date getCalendarDate(long millis) {
        return getCalendarDate(millis, (CalendarDate) newCalendarDate());
    }

    public /* bridge */ /* synthetic */ CalendarDate getCalendarDate(long millis, TimeZone zone) {
        return getCalendarDate(millis, zone);
    }

    public Date getCalendarDate(long millis, TimeZone zone) {
        return getCalendarDate(millis, (CalendarDate) newCalendarDate(zone));
    }

    public /* bridge */ /* synthetic */ CalendarDate getCalendarDate(long millis, CalendarDate date) {
        return getCalendarDate(millis, date);
    }

    public Date getCalendarDate(long millis, CalendarDate date) {
        Date ldate = (Date) super.getCalendarDate(millis, date);
        return adjustYear(ldate, millis, ldate.getZoneOffset());
    }

    private Date adjustYear(Date ldate, long millis, int zoneOffset) {
        int i = this.eras.length - 1;
        while (true) {
            if (i < 0) {
                break;
            }
            Era era = this.eras[i];
            long since = era.getSince((TimeZone) null);
            if (era.isLocalTime()) {
                since -= (long) zoneOffset;
            }
            if (millis >= since) {
                ldate.setLocalEra(era);
                ldate.setLocalYear((ldate.getNormalizedYear() - era.getSinceDate().getYear()) + 1);
                break;
            }
            i--;
        }
        if (i < 0) {
            ldate.setLocalEra((Era) null);
            ldate.setLocalYear(ldate.getNormalizedYear());
        }
        ldate.setNormalized(true);
        return ldate;
    }

    public /* bridge */ /* synthetic */ CalendarDate newCalendarDate() {
        return newCalendarDate();
    }

    public Date newCalendarDate() {
        return new Date();
    }

    public /* bridge */ /* synthetic */ CalendarDate newCalendarDate(TimeZone zone) {
        return newCalendarDate(zone);
    }

    public Date newCalendarDate(TimeZone zone) {
        return new Date(zone);
    }

    public boolean validate(CalendarDate date) {
        Date ldate = (Date) date;
        Era era = ldate.getEra();
        if (era == null) {
            ldate.setNormalizedYear(ldate.getYear());
        } else if (!validateEra(era)) {
            return false;
        } else {
            ldate.setNormalizedYear(era.getSinceDate().getYear() + ldate.getYear());
        }
        return super.validate(ldate);
    }

    private boolean validateEra(Era era) {
        for (Era era2 : this.eras) {
            if (era == era2) {
                return true;
            }
        }
        return false;
    }

    public boolean normalize(CalendarDate date) {
        if (date.isNormalized()) {
            return true;
        }
        normalizeYear(date);
        Date ldate = (Date) date;
        super.normalize(ldate);
        boolean hasMillis = false;
        long millis = 0;
        int year = ldate.getNormalizedYear();
        Era era = null;
        int i = this.eras.length - 1;
        while (true) {
            if (i < 0) {
                break;
            }
            era = this.eras[i];
            if (!era.isLocalTime()) {
                if (!hasMillis) {
                    millis = super.getTime(date);
                    hasMillis = true;
                }
                if (millis >= era.getSince(date.getZone())) {
                    break;
                }
            } else {
                CalendarDate sinceDate = era.getSinceDate();
                int sinceYear = sinceDate.getYear();
                if (year > sinceYear) {
                    break;
                } else if (year != sinceYear) {
                    continue;
                } else {
                    int month = ldate.getMonth();
                    int sinceMonth = sinceDate.getMonth();
                    if (month > sinceMonth) {
                        break;
                    } else if (month != sinceMonth) {
                        continue;
                    } else {
                        int day = ldate.getDayOfMonth();
                        int sinceDay = sinceDate.getDayOfMonth();
                        if (day > sinceDay) {
                            break;
                        } else if (day == sinceDay) {
                            if (ldate.getTimeOfDay() < sinceDate.getTimeOfDay()) {
                                i--;
                            }
                        }
                    }
                }
            }
            i--;
        }
        if (i >= 0) {
            ldate.setLocalEra(era);
            ldate.setLocalYear((ldate.getNormalizedYear() - era.getSinceDate().getYear()) + 1);
        } else {
            ldate.setEra((Era) null);
            ldate.setLocalYear(year);
            ldate.setNormalizedYear(year);
        }
        ldate.setNormalized(true);
        return true;
    }

    /* access modifiers changed from: package-private */
    public void normalizeMonth(CalendarDate date) {
        normalizeYear(date);
        super.normalizeMonth(date);
    }

    /* access modifiers changed from: package-private */
    public void normalizeYear(CalendarDate date) {
        Date ldate = (Date) date;
        Era era = ldate.getEra();
        if (era == null || !validateEra(era)) {
            ldate.setNormalizedYear(ldate.getYear());
        } else {
            ldate.setNormalizedYear((era.getSinceDate().getYear() + ldate.getYear()) - 1);
        }
    }

    public boolean isLeapYear(int gregorianYear) {
        return CalendarUtils.isGregorianLeapYear(gregorianYear);
    }

    public boolean isLeapYear(Era era, int year) {
        if (era == null) {
            return isLeapYear(year);
        }
        return isLeapYear((era.getSinceDate().getYear() + year) - 1);
    }

    public void getCalendarDateFromFixedDate(CalendarDate date, long fixedDate) {
        Date ldate = (Date) date;
        super.getCalendarDateFromFixedDate(ldate, fixedDate);
        adjustYear(ldate, (fixedDate - 719163) * 86400000, 0);
    }
}
