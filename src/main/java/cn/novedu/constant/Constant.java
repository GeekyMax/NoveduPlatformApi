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
        TOKEN_MAP.put("3160102210", "eyJhbGciOiJIUzI1NiJ9.eyJ1aWQiOiI1Njk2OWJjOWYxOGQxMWU4OTczNDAwMTYzZTA0M2IwMiIsInN1YiI6IjU2OTY5YmM5ZjE4ZDExZTg5NzM0MDAxNjNlMDQzYjAyIiwiaWF0IjoxNTQzMzI3MTk3LCJqdGkiOiJpVnYwRGhZN1RTIn0.wASjsRV4cVSguJFzmxTJxWOgQeqC60m__PUEeqDIrl0");
        TOKEN_MAP.put("3160102211", "eyJhbGciOiJIUzI1NiJ9.eyJ1aWQiOiI1NmMyMzVhMmYxOGQxMWU4OTczNDAwMTYzZTA0M2IwMiIsInN1YiI6IjU2YzIzNWEyZjE4ZDExZTg5NzM0MDAxNjNlMDQzYjAyIiwiaWF0IjoxNTQzMzI3MTk4LCJqdGkiOiI5dkF5NXk2YlhZIn0.mp-x-bQnAvbISLnaRC9oyyAy6JLQ-YRnsGh9WcX8AKE");
        TOKEN_MAP.put("3160102212", "eyJhbGciOiJIUzI1NiJ9.eyJ1aWQiOiI1NmRhZGZjNmYxOGQxMWU4OTczNDAwMTYzZTA0M2IwMiIsInN1YiI6IjU2ZGFkZmM2ZjE4ZDExZTg5NzM0MDAxNjNlMDQzYjAyIiwiaWF0IjoxNTQzMzI3MTk4LCJqdGkiOiJQTWdFdWhhcGlmIn0._OdaisJUWyxJvqkv-ePJZYUD3NKNNDelO9R1XSs_tZA");
        TOKEN_MAP.put("3160102213", "eyJhbGciOiJIUzI1NiJ9.eyJ1aWQiOiI1NmYyYWQ4MGYxOGQxMWU4OTczNDAwMTYzZTA0M2IwMiIsInN1YiI6IjU2ZjJhZDgwZjE4ZDExZTg5NzM0MDAxNjNlMDQzYjAyIiwiaWF0IjoxNTQzMzI3MTk4LCJqdGkiOiJwczdsamlTa1dKIn0.B8L_L-I5JRsIaN7SxwrSEwSUl8DM7NBvziA-yjbOzg0");
        TOKEN_MAP.put("3160102214", "eyJhbGciOiJIUzI1NiJ9.eyJ1aWQiOiI1NzBhODJiY2YxOGQxMWU4OTczNDAwMTYzZTA0M2IwMiIsInN1YiI6IjU3MGE4MmJjZjE4ZDExZTg5NzM0MDAxNjNlMDQzYjAyIiwiaWF0IjoxNTQzMzI3MTk4LCJqdGkiOiJFMU50d1VFdnhxIn0.b4wYdRJw4251iK097H4JGm8IFe3v5MYIIIcH7iWqV1E");
        TOKEN_MAP.put("3160102215", "eyJhbGciOiJIUzI1NiJ9.eyJ1aWQiOiI1NzIyOGQxMWYxOGQxMWU4OTczNDAwMTYzZTA0M2IwMiIsInN1YiI6IjU3MjI4ZDExZjE4ZDExZTg5NzM0MDAxNjNlMDQzYjAyIiwiaWF0IjoxNTQzMzI3MTk4LCJqdGkiOiJiRHppRHl2MldZIn0.r6CLciDrmDIhhoH7qmz0i3_N5WaYoZSiaC0LCP9VgtA");
        TOKEN_MAP.put("3160102216", "eyJhbGciOiJIUzI1NiJ9.eyJ1aWQiOiI1NzNhZWQ1OGYxOGQxMWU4OTczNDAwMTYzZTA0M2IwMiIsInN1YiI6IjU3M2FlZDU4ZjE4ZDExZTg5NzM0MDAxNjNlMDQzYjAyIiwiaWF0IjoxNTQzMzI3MTk4LCJqdGkiOiJUNnh5dWY1R3R2In0.tAxN1C0QjM_09PgQ8q9j9y_80o0pR0YlRShkxEKse4I");
        TOKEN_MAP.put("3160102217", "eyJhbGciOiJIUzI1NiJ9.eyJ1aWQiOiI1NzUzNTg4MmYxOGQxMWU4OTczNDAwMTYzZTA0M2IwMiIsInN1YiI6IjU3NTM1ODgyZjE4ZDExZTg5NzM0MDAxNjNlMDQzYjAyIiwiaWF0IjoxNTQzMzI3MTk5LCJqdGkiOiI0eVRVeElnTXNiIn0.RrjdXV6p99869UySYOz5QmKiCded-aUte4obZYcu0kQ");
        TOKEN_MAP.put("3160102218", "eyJhbGciOiJIUzI1NiJ9.eyJ1aWQiOiI1NzZiY2U1MWYxOGQxMWU4OTczNDAwMTYzZTA0M2IwMiIsInN1YiI6IjU3NmJjZTUxZjE4ZDExZTg5NzM0MDAxNjNlMDQzYjAyIiwiaWF0IjoxNTQzMzI3MTk5LCJqdGkiOiJjUXYwNWFjblZuIn0.CL6m6wWoelCwHbl5Lbs-V4KQoDq8IDzTqjaPgpt4loI");
        TOKEN_MAP.put("3160102219", "eyJhbGciOiJIUzI1NiJ9.eyJ1aWQiOiI1Nzg0MmIwZGYxOGQxMWU4OTczNDAwMTYzZTA0M2IwMiIsInN1YiI6IjU3ODQyYjBkZjE4ZDExZTg5NzM0MDAxNjNlMDQzYjAyIiwiaWF0IjoxNTQzMzI3MTk5LCJqdGkiOiJoUjFYQ21NaVhZIn0.vmyNyKH62MYmHDJV1QQfF_ETqCFUhH-r8op_4jb5NP8");
        TOKEN_MAP.put("3160102220", "eyJhbGciOiJIUzI1NiJ9.eyJ1aWQiOiI1N2EwNjkzM2YxOGQxMWU4OTczNDAwMTYzZTA0M2IwMiIsInN1YiI6IjU3YTA2OTMzZjE4ZDExZTg5NzM0MDAxNjNlMDQzYjAyIiwiaWF0IjoxNTQzMzI3MTk5LCJqdGkiOiJ0bkRDUWZnNUhYIn0.e_JA84m1WccAXoQ9ebZXI3cM8WGJ7CI9aSHTYADk61M");
        TOKEN_MAP.put("3160102221", "eyJhbGciOiJIUzI1NiJ9.eyJ1aWQiOiI1N2I4NDhmZGYxOGQxMWU4OTczNDAwMTYzZTA0M2IwMiIsInN1YiI6IjU3Yjg0OGZkZjE4ZDExZTg5NzM0MDAxNjNlMDQzYjAyIiwiaWF0IjoxNTQzMzI3MTk5LCJqdGkiOiJjbzRjTlBMbUtYIn0.MIgzL0fcJuNBEEarQbchAfxtIeG8RqkLk_EY0Obt1NU");
        TOKEN_MAP.put("3160102222", "eyJhbGciOiJIUzI1NiJ9.eyJ1aWQiOiI1N2QwMGY0OWYxOGQxMWU4OTczNDAwMTYzZTA0M2IwMiIsInN1YiI6IjU3ZDAwZjQ5ZjE4ZDExZTg5NzM0MDAxNjNlMDQzYjAyIiwiaWF0IjoxNTQzMzI3MTk5LCJqdGkiOiJ4cnE0aW9LYVZTIn0.JeCI0YRWpmiw7Emu9TMF73uGHxKfzuuk1P9jgUH68KE");
        TOKEN_MAP.put("3160102223", "eyJhbGciOiJIUzI1NiJ9.eyJ1aWQiOiI1N2U4ZDQ3M2YxOGQxMWU4OTczNDAwMTYzZTA0M2IwMiIsInN1YiI6IjU3ZThkNDczZjE4ZDExZTg5NzM0MDAxNjNlMDQzYjAyIiwiaWF0IjoxNTQzMzI3MTk5LCJqdGkiOiIwTDFGQ2duN0VOIn0.dRzn2w-clSAuuVxrGb7qxADfBQxI2wRNfFchRjv7yBg");
        TOKEN_MAP.put("3160102224", "eyJhbGciOiJIUzI1NiJ9.eyJ1aWQiOiI1ODAzNThlYWYxOGQxMWU4OTczNDAwMTYzZTA0M2IwMiIsInN1YiI6IjU4MDM1OGVhZjE4ZDExZTg5NzM0MDAxNjNlMDQzYjAyIiwiaWF0IjoxNTQzMzI3MTk5LCJqdGkiOiJWaWZHalV3MGZoIn0.gDpFBKogD_DH18pb43hM1k578FMIAnv91MTS-iSiBAA");
        TOKEN_MAP.put("3160102225", "eyJhbGciOiJIUzI1NiJ9.eyJ1aWQiOiI1ODFjNmZkMWYxOGQxMWU4OTczNDAwMTYzZTA0M2IwMiIsInN1YiI6IjU4MWM2ZmQxZjE4ZDExZTg5NzM0MDAxNjNlMDQzYjAyIiwiaWF0IjoxNTQzMzI3MTk5LCJqdGkiOiJjTnZLN1RweEo2In0.TNVgQrp1tRhEpSM1vBjCjH-AXH2KL_U6Up-LRllsswk");
        TOKEN_MAP.put("3160102226", "eyJhbGciOiJIUzI1NiJ9.eyJ1aWQiOiI1ODM0ZDQ4MWYxOGQxMWU4OTczNDAwMTYzZTA0M2IwMiIsInN1YiI6IjU4MzRkNDgxZjE4ZDExZTg5NzM0MDAxNjNlMDQzYjAyIiwiaWF0IjoxNTQzMzI3MTk5LCJqdGkiOiJVQXFPZ2FQS2xMIn0.rcbLRFihx6G3GNR_nVgFAoWClL-dhPT-Bu43ipe4R1c");
        TOKEN_MAP.put("3160102227", "eyJhbGciOiJIUzI1NiJ9.eyJ1aWQiOiI1ODRjNzFjZWYxOGQxMWU4OTczNDAwMTYzZTA0M2IwMiIsInN1YiI6IjU4NGM3MWNlZjE4ZDExZTg5NzM0MDAxNjNlMDQzYjAyIiwiaWF0IjoxNTQzMzI3MTk5LCJqdGkiOiJuRURGcG5FZWU0In0._2ry1H5qiKe-nmIttzrL2nlumr7bYWRUiNLcowHCoFw");
        TOKEN_MAP.put("3160102228", "eyJhbGciOiJIUzI1NiJ9.eyJ1aWQiOiI1ODY0MzhjMWYxOGQxMWU4OTczNDAwMTYzZTA0M2IwMiIsInN1YiI6IjU4NjQzOGMxZjE4ZDExZTg5NzM0MDAxNjNlMDQzYjAyIiwiaWF0IjoxNTQzMzI3MTk5LCJqdGkiOiJUNHVSZmtTWEhhIn0.caTrsan7nntDWVgd5pR_ZzF-oJR817opVicG9hKYECc");
        TOKEN_MAP.put("3160102229", "eyJhbGciOiJIUzI1NiJ9.eyJ1aWQiOiI1ODdlNmQ1Y2YxOGQxMWU4OTczNDAwMTYzZTA0M2IwMiIsInN1YiI6IjU4N2U2ZDVjZjE4ZDExZTg5NzM0MDAxNjNlMDQzYjAyIiwiaWF0IjoxNTQzMzI3MTk5LCJqdGkiOiJuUWlSbTBHc1paIn0.VwWspGgNObe67rNAzZsR64FdlQwtpr_qYxaPjT2e8i0");
    }
}
