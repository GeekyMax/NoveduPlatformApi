package cn.novedu.constant;

import java.util.HashMap;
import java.util.Map;

public class Constant {
    public static final String TOKEN_NAME = "X-NOV-TOKEN";
    public static final String JWT_SECRET = "7786df7fc3a34e26a61c034d5ec8245d";
    public static final String TEACHER_TOKEN = "eyJhbGciOiJIUzI1NiJ9.eyJ1aWQiOiJlNGEyNGUyYzBiMzI0N2UzOGFkMzdkOTcxY2E4YzE2MiIsInN1YiI6ImU0YTI0ZTJjMGIzMjQ3ZTM4YWQzN2Q5NzFjYThjMTYyIiwiZXhwIjoxNTQ0NTE4ODAzLCJpYXQiOjE1NDMwNDc1NzQsImp0aSI6IlBvSW1IU0kzU3UifQ.gVMyOKrZtLOcirCjfE9wBn1zwpNmE596g5OytnpNbIw";
    public static final String STUDENT_TOKEN = "eyJhbGciOiJIUzI1NiJ9.eyJ1aWQiOiI0NDYxNTlkNWZlYzM0Zjc4OGI5MTc1ZjkzNTNlZThjYSIsInN1YiI6IjQ0NjE1OWQ1ZmVjMzRmNzg4YjkxNzVmOTM1M2VlOGNhIiwiZXhwIjoxNTQzMTkzOTg1LCJpYXQiOjE1NDMwNDM3ODgsImp0aSI6ImxnamNWQzBKMzYifQ.ij6mLFxPX1oJh1YiV4nBVp98ybl20a3I7HbuWVAlCGE";
    public static Map<String, String> TOKEN_MAP;

    static {
        TOKEN_MAP = new HashMap<>();
        TOKEN_MAP.put("3160102210", "eyJhbGciOiJIUzI1NiJ9.eyJ1aWQiOiI4ODQyOGYwMjg2M2I0OGE3ODY5OWM1NGVkMjliNDBkMyIsInN1YiI6Ijg4NDI4ZjAyODYzYjQ4YTc4Njk5YzU0ZWQyOWI0MGQzIiwiaWF0IjoxNTQzMjM1NDEyLCJqdGkiOiJsYlAydFZoZHN1In0.0KM_1WK2HaQlwIsLxQsqEgNLktMDJLVlQbxAZ8g4qVg");
        TOKEN_MAP.put("3160102211", "eyJhbGciOiJIUzI1NiJ9.eyJ1aWQiOiI4NWQyMTY4MGQ0N2I0NmRjYjM3MTIzNTljMGQ0MDBjYyIsInN1YiI6Ijg1ZDIxNjgwZDQ3YjQ2ZGNiMzcxMjM1OWMwZDQwMGNjIiwiaWF0IjoxNTQzMjM1NDE0LCJqdGkiOiJraEZEOUQwUE9nIn0.TR3vpJV4Kl6ZoxM30SL4UHu6JxHR-uu1qAl6HDeBm4o");
        TOKEN_MAP.put("3160102212", "eyJhbGciOiJIUzI1NiJ9.eyJ1aWQiOiJlNWRjM2EzMjgxMzA0MDUxYmRhODUxMzIzNTNjNTQxOSIsInN1YiI6ImU1ZGMzYTMyODEzMDQwNTFiZGE4NTEzMjM1M2M1NDE5IiwiaWF0IjoxNTQzMjM1NDE0LCJqdGkiOiJuYXQ2Vjk1VWkxIn0.C7C65zC4F9gp5vNYRakTIdBwV1AwUA8KERJyECBI8l0");
        TOKEN_MAP.put("3160102213", "eyJhbGciOiJIUzI1NiJ9.eyJ1aWQiOiJjYTJjMGM4NTQyMmI0NmU4OTc1NmFkMDJiMjQ1YjM0NSIsInN1YiI6ImNhMmMwYzg1NDIyYjQ2ZTg5NzU2YWQwMmIyNDViMzQ1IiwiaWF0IjoxNTQzMjM1NDE0LCJqdGkiOiJ5cFFKN2pPV3lJIn0.-bpNBTnUApSYb3_ZWj5CLGXFKF6Hqg6I0R8jwDdPWuU");
        TOKEN_MAP.put("3160102214", "eyJhbGciOiJIUzI1NiJ9.eyJ1aWQiOiI3NGMzN2QxM2NhN2Q0OTRjYjI5MTkyMmFhMTJiMmY2ZiIsInN1YiI6Ijc0YzM3ZDEzY2E3ZDQ5NGNiMjkxOTIyYWExMmIyZjZmIiwiaWF0IjoxNTQzMjM1NDE0LCJqdGkiOiJPdmE1QklBVFp5In0.1YIM6w2bR1nRpGbuVnlEhGlKwzpF69rZo3dvARbq3p0");
        TOKEN_MAP.put("3160102215", "eyJhbGciOiJIUzI1NiJ9.eyJ1aWQiOiI2NWYzMmNmMWJkMWE0NGQ3YTljNTA2NzVkYTc4ZDE0YSIsInN1YiI6IjY1ZjMyY2YxYmQxYTQ0ZDdhOWM1MDY3NWRhNzhkMTRhIiwiaWF0IjoxNTQzMjM1NDE0LCJqdGkiOiJtM256QWN6NHpJIn0.6_DZBznHHNwwziiGc5yYcpufCqsL4wO1quyzb7ulkOc");
        TOKEN_MAP.put("3160102216", "eyJhbGciOiJIUzI1NiJ9.eyJ1aWQiOiIxM2VmNjY2NzNlMTk0OGVmYWU2ODg5ZTgxNTVhMTE0MyIsInN1YiI6IjEzZWY2NjY3M2UxOTQ4ZWZhZTY4ODllODE1NWExMTQzIiwiaWF0IjoxNTQzMjM1NDE0LCJqdGkiOiJVOXoycU9aekVjIn0.ZCfWTeji1JxzhVsWVQP-KgXx7JdhBQyM8b56otcGgJE");
        TOKEN_MAP.put("3160102217", "eyJhbGciOiJIUzI1NiJ9.eyJ1aWQiOiIwN2ViMGZiYzY0MGU0NjA0YTllMWI0OTE5MzBlMzI4MCIsInN1YiI6IjA3ZWIwZmJjNjQwZTQ2MDRhOWUxYjQ5MTkzMGUzMjgwIiwiaWF0IjoxNTQzMjM1NDE0LCJqdGkiOiJianNLaEh1RDZiIn0.DqKiNLNcwMmwlCBpDaP7St6U62Un96z-mcYw0fdiuu8");
        TOKEN_MAP.put("3160102218", "eyJhbGciOiJIUzI1NiJ9.eyJ1aWQiOiJlYzEzMThjMTBmZDE0OGJkYWJlY2U3NGY5OTlhZDUzNyIsInN1YiI6ImVjMTMxOGMxMGZkMTQ4YmRhYmVjZTc0Zjk5OWFkNTM3IiwiaWF0IjoxNTQzMjM1NDE0LCJqdGkiOiIyZ3g1RVZjdk91In0.aABSpDS9YYXy48UTDS34x1qWMRsMAzYrhivN0Of17-A");
        TOKEN_MAP.put("3160102219", "eyJhbGciOiJIUzI1NiJ9.eyJ1aWQiOiI4NTc4YWY3NmZmN2Q0ODI4YWI2MzhmNzNiY2NjMWU0ZiIsInN1YiI6Ijg1NzhhZjc2ZmY3ZDQ4MjhhYjYzOGY3M2JjY2MxZTRmIiwiaWF0IjoxNTQzMjM1NDE0LCJqdGkiOiJoaFZtUHlyN0tuIn0.p6nbEGZ9qIe9Mga8BbPVnsExJ9wPm8DvJiUzdofiv88");
        TOKEN_MAP.put("3160102220", "eyJhbGciOiJIUzI1NiJ9.eyJ1aWQiOiI4ZmZkMzNhZDQ4MzE0NTRhYWQyYTY1ZmM1ZjcwMGU5MSIsInN1YiI6IjhmZmQzM2FkNDgzMTQ1NGFhZDJhNjVmYzVmNzAwZTkxIiwiaWF0IjoxNTQzMjM1NDE0LCJqdGkiOiI2aDFWWjcxQnBMIn0.PcavnAgoeaBHSd5JS8q-uKOR_KYbtTgP16NIaGGu2jU");
        TOKEN_MAP.put("3160102221", "eyJhbGciOiJIUzI1NiJ9.eyJ1aWQiOiJjNjE1OTM1MWEzY2I0MTNjODkzOGQ5OTRkYzAwOTJkNyIsInN1YiI6ImM2MTU5MzUxYTNjYjQxM2M4OTM4ZDk5NGRjMDA5MmQ3IiwiaWF0IjoxNTQzMjM1NDE0LCJqdGkiOiJiVGd2cnpuTnpmIn0.N_hHbXaxMyjwlJMAyE9nN2PlPdI-vJWaCt5rNpjkOfQ");
        TOKEN_MAP.put("3160102222", "eyJhbGciOiJIUzI1NiJ9.eyJ1aWQiOiJmM2ZhNTAyNDBlMjI0NGE0OWE0YjdhM2EwMTdiOWM3YiIsInN1YiI6ImYzZmE1MDI0MGUyMjQ0YTQ5YTRiN2EzYTAxN2I5YzdiIiwiaWF0IjoxNTQzMjM1NDE0LCJqdGkiOiJuY01PNVAySlhJIn0.V6z9RhoNP9l3u2W_A_zrL5BmAywREFqmuCojnP-UEZs");
        TOKEN_MAP.put("3160102223", "eyJhbGciOiJIUzI1NiJ9.eyJ1aWQiOiJkMzJlOTVlOGY5N2Q0NDdmYmRkODhhMGU5NTc4ZTNiMiIsInN1YiI6ImQzMmU5NWU4Zjk3ZDQ0N2ZiZGQ4OGEwZTk1NzhlM2IyIiwiaWF0IjoxNTQzMjM1NDE0LCJqdGkiOiJKRUlnbk5NSWNOIn0.u0uDpt_fjqKKr2KheJz3d7nNDZ_0NKHmx9rE0mTuAVc");
        TOKEN_MAP.put("3160102224", "eyJhbGciOiJIUzI1NiJ9.eyJ1aWQiOiIxZjlmODlkZTY5NzA0NzA2OWQ5NDUxNDUzYTRiYjFiZCIsInN1YiI6IjFmOWY4OWRlNjk3MDQ3MDY5ZDk0NTE0NTNhNGJiMWJkIiwiaWF0IjoxNTQzMjM1NDE0LCJqdGkiOiJMNUxVMEVQS1VHIn0.e3PDBa82DNZAQzOmS6DetRTb9C5S59i50nSdjl1hrH4");
        TOKEN_MAP.put("3160102225", "eyJhbGciOiJIUzI1NiJ9.eyJ1aWQiOiIyZWZjNmMxZDA4MjA0ZTFkODQxOWY4ZWRkZDM3NjVjOCIsInN1YiI6IjJlZmM2YzFkMDgyMDRlMWQ4NDE5ZjhlZGRkMzc2NWM4IiwiaWF0IjoxNTQzMjM1NDE0LCJqdGkiOiJxY3oyZWZ2d3YwIn0.u7MfU-DnllwtUOTsOp0Q4jN2DenkV_EBeJBGMavBrsg");
        TOKEN_MAP.put("3160102226", "eyJhbGciOiJIUzI1NiJ9.eyJ1aWQiOiI3MGFlNzUyNTkxYjE0MzNkODcyMjQ0Mjk2NDBjN2JiNyIsInN1YiI6IjcwYWU3NTI1OTFiMTQzM2Q4NzIyNDQyOTY0MGM3YmI3IiwiaWF0IjoxNTQzMjM1NDE0LCJqdGkiOiJQeDZTZnd4VGtKIn0.TCda-YMDptFuxHN_Klt4Sk6VAl8nfl3HQnQIOgNLxr4");
        TOKEN_MAP.put("3160102227", "eyJhbGciOiJIUzI1NiJ9.eyJ1aWQiOiI2ZjUxZTY0ZDA0ZDk0NTFkOWY2MGI3MzVjNjZjODE2NSIsInN1YiI6IjZmNTFlNjRkMDRkOTQ1MWQ5ZjYwYjczNWM2NmM4MTY1IiwiaWF0IjoxNTQzMjM1NDE0LCJqdGkiOiI2SXJXYXRMQkpwIn0.6KlgfgEUiGKdoSJ8mSjuLIjNlbAtZ9Ku8NLloby7Lms");
        TOKEN_MAP.put("3160102228", "eyJhbGciOiJIUzI1NiJ9.eyJ1aWQiOiIxZjlmZTBmMDhiMjM0ZTQ4YmMwNTQ3ZDI2OTU2Zjg0MCIsInN1YiI6IjFmOWZlMGYwOGIyMzRlNDhiYzA1NDdkMjY5NTZmODQwIiwiaWF0IjoxNTQzMjM1NDE0LCJqdGkiOiJCNG5PZXpjOUs4In0.5cUyweMi3lFXU5gPwR6LrEjkOPJsnS99Y0tqNAt2Tr8");
        TOKEN_MAP.put("3160102229", "eyJhbGciOiJIUzI1NiJ9.eyJ1aWQiOiIyOTdlMDYwYmYyYmY0MWVhODA5YWE0MmUzNGIyZWY5NCIsInN1YiI6IjI5N2UwNjBiZjJiZjQxZWE4MDlhYTQyZTM0YjJlZjk0IiwiaWF0IjoxNTQzMjM1NDE0LCJqdGkiOiJHd1NISlhZOWV3In0.9l2ycQL2m0lUwUpQFVCz3Ap7VcLe3kXiBgm1ge59fdU");

    }
}
