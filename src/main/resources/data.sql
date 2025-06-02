INSERT INTO users (id, userid, password, nickname) VALUES (1 ,'user1', 'pass1', '홍길동');
INSERT INTO users (id, userid, password, nickname) VALUES (2 ,'user2', 'pass2', '임꺽정');

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

INSERT INTO book (title, author, publisher, content, category_id, user_id, created_at, updated_at)
VALUES
('도서관의 역사', '존 라이더', '열린책들', '도서관의 기원과 발전에 대한 역사적 고찰', 0, 1, CURRENT_TIMESTAMP, CURRENT_TIMESTAMP),
('정보 분류법 개론', '이성훈', '문헌정보출판사', '지식 분류 체계에 대한 입문서', 0, 1, CURRENT_TIMESTAMP, CURRENT_TIMESTAMP),

('서양 철학의 흐름', '이창복', '지식의숲', '철학사 입문', 100, 2, CURRENT_TIMESTAMP, CURRENT_TIMESTAMP),
('논리와 사고', '박재홍', '철학과현실사', '철학적 사고를 키우는 책', 100, 2, CURRENT_TIMESTAMP, CURRENT_TIMESTAMP),

('종교와 문명', '정현석', '문명출판사', '종교와 문명의 상관관계', 200, 1, CURRENT_TIMESTAMP, CURRENT_TIMESTAMP),
('세계 종교 개론', '이경우', '종교문화사', '종교의 개요와 역사', 200, 2, CURRENT_TIMESTAMP, CURRENT_TIMESTAMP),

('사회학 입문', '김민수', '사회연구사', '사회학 이론과 실제', 300, 1, CURRENT_TIMESTAMP, CURRENT_TIMESTAMP),
('현대 사회 문제', '이정화', '정치사회사', '현대 사회의 이슈 분석', 300, 2, CURRENT_TIMESTAMP, CURRENT_TIMESTAMP),

('물리학의 세계', '알베르트 김', '과학세상', '물리학 기본 개념', 400, 1, CURRENT_TIMESTAMP, CURRENT_TIMESTAMP),
('생명의 이해', '한지은', '바이오북스', '생물학 입문', 400, 2, CURRENT_TIMESTAMP, CURRENT_TIMESTAMP),

('기계공학 기초', '정우진', '공학사', '기계공학 개론', 500, 1, CURRENT_TIMESTAMP, CURRENT_TIMESTAMP),
('전기전자 입문', '유상민', '기술교육사', '전기 전자 이론', 500, 2, CURRENT_TIMESTAMP, CURRENT_TIMESTAMP),

('예술의 역사', '이주영', '예술의눈', '예술과 시대 흐름', 600, 1, CURRENT_TIMESTAMP, CURRENT_TIMESTAMP),
('현대 미술 이야기', '배수빈', '아트북', '미술의 발전 과정', 600, 2, CURRENT_TIMESTAMP, CURRENT_TIMESTAMP),

('한국어 문법', '최민영', '한글사', '한국어 문법의 체계', 700, 1, CURRENT_TIMESTAMP, CURRENT_TIMESTAMP),
('언어와 사고', '김연우', '언어문화사', '언어가 사고에 미치는 영향', 700, 2, CURRENT_TIMESTAMP, CURRENT_TIMESTAMP),

('고전 문학 산책', '박지혜', '문학동네', '고전 문학 해설', 800, 1, CURRENT_TIMESTAMP, CURRENT_TIMESTAMP),
('시의 이해', '이하늘', '시와소리', '시의 구조와 의미', 800, 2, CURRENT_TIMESTAMP, CURRENT_TIMESTAMP),

('한국사 이야기', '조수현', '역사책방', '한국사의 주요 사건들', 900, 1, CURRENT_TIMESTAMP, CURRENT_TIMESTAMP),
('세계사 연표', '남기훈', '세계문화사', '세계사 연대표 중심 설명', 900, 2, CURRENT_TIMESTAMP, CURRENT_TIMESTAMP);