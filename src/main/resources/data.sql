INSERT INTO users (userid, password, name, created_at) VALUES ('admin', '1234', '관리자', CURRENT_TIMESTAMP);
INSERT INTO users (userid, password, name, created_at) VALUES ('lds', 'abcd', '이동섭', CURRENT_TIMESTAMP);

INSERT INTO category (id, name) VALUES (0, '총류');
INSERT INTO category (id, name) VALUES (100, '철학');
INSERT INTO category (id, name) VALUES (200, '종교');
INSERT INTO category (id, name) VALUES (300, '사회과학');
INSERT INTO category (id, name) VALUES (400, '순수과학');
INSERT INTO category (id, name) VALUES (500, '기술과학');
INSERT INTO category (id, name) VALUES (600, '예술');
INSERT INTO category (id, name) VALUES (700, '언어');
INSERT INTO category (id, name) VALUES (800, '문학');
INSERT INTO category (id, name) VALUES (900, '역사');

-- 총류 (0)
INSERT INTO book (title, author, publisher, content, category_id, user_id) VALUES
('도서관의 역사', '존 라이더', '열린책들', '도서관의 기원과 발전에 대한 역사적 고찰', 0, 1),
('정보 분류법 개론', '이성훈', '문헌정보출판사', '지식 분류 체계에 대한 입문서', 0, 1);

-- 철학 (100)
INSERT INTO book (title, author, publisher, content, category_id, user_id) VALUES
('소크라테스의 변론', '플라톤', '그린북스', '소크라테스의 철학과 죽음에 대한 이야기', 100, 1),
('니체, 삶을 말하다', '프리드리히 니체', '인문서원', '삶과 운명에 대한 깊은 성찰', 100, 1);

-- 종교 (200)
INSERT INTO book (title, author, publisher, content, category_id, user_id) VALUES
('세계 종교의 이해', '허버트 스트레이트', '현대종교', '각 종교의 기원과 교리를 소개', 200, 1),
('기독교 핵심 교리', 'C.S. 루이스', '복음사', '기독교 신앙의 핵심을 간결히 설명', 200, 1);

-- 사회과학 (300)
INSERT INTO book (title, author, publisher, content, category_id, user_id) VALUES
('경제학 콘서트', '팀 하포드', '웅진지식하우스', '일상 속 경제 원리를 흥미롭게 설명', 300, 1),
('심리학의 이해', '폴 블룸', '북로드', '인간의 마음과 행동을 탐구', 300, 1);

-- 순수과학 (400)
INSERT INTO book (title, author, publisher, content, category_id, user_id) VALUES
('자바의 정석', '남궁성', '도우출판', '자바 기본서로 최고의 책', 400, 1),
('혼자 공부하는 자바', '신용권', '한빛미디어', '자바를 처음 배우는 입문자용 도서', 400, 1);

-- 기술과학 (500)
INSERT INTO book (title, author, publisher, content, category_id, user_id) VALUES
('클린 코드', '로버트 마틴', '인사이트', '좋은 코드 작성을 위한 원칙과 사례', 500, 1),
('프로그래밍 실전 기술', '이재홍', '테크북스', '개발 현장에서 유용한 실전 기술 소개', 500, 1);

-- 예술 (600)
INSERT INTO book (title, author, publisher, content, category_id, user_id) VALUES
('색채의 역사', '이윤정', '디자인하우스', '색의 기원과 의미를 예술과 함께 설명', 600, 1),
('사진의 모든 것', '앤드류 톰슨', '비에이북스', '사진 예술의 이론과 실습', 600, 1);

-- 언어 (700)
INSERT INTO book (title, author, publisher, content, category_id, user_id) VALUES
('영문법 무작정 따라하기', '송미정', '길벗이지톡', '기초부터 고급까지 영문법 학습서', 700, 1),
('한자어의 이해', '김정환', '한글문화사', '한자 기반 어휘의 구조와 의미', 700, 1);

-- 문학 (800)
INSERT INTO book (title, author, publisher, content, category_id, user_id) VALUES
('데미안', '헤르만 헤세', '민음사', '성장과 내면의 자아를 그린 고전 명작', 800, 1),
('태백산맥', '조정래', '해냄출판사', '한국 현대사를 배경으로 한 장편소설', 800, 1);

-- 역사 (900)
INSERT INTO book (title, author, publisher, content, category_id, user_id) VALUES
('한국사 편지', '박은봉', '책과함께', '초등학생부터 쉽게 읽을 수 있는 한국사', 900, 1),
('세계사 산책', '고토 벤', '사계절출판사', '세계사의 흐름을 한눈에 볼 수 있는 책', 900, 1);
