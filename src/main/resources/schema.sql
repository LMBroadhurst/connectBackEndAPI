DROP TABLE IF EXISTS interests_mapper;
DROP TABLE IF EXISTS interest_types;
DROP TABLE IF EXISTS post_types CASCADE;
DROP TYPE IF EXISTS interests_career;
DROP TYPE IF EXISTS posts_type;


CREATE TYPE interests_career AS ENUM ('SOFTWARE_ENGINEERING',
                                          'MACHINE_LEARNING',
                                          'AI',
                                          'ROBOTICS',
                                          'FULL_STACK_DEVELOPMENT',
                                          'BACK_END_DEVELOPMENT',
                                          'FRONT_END_DEVELOPMENT',
                                          'BUSINESS_DEVELOPMENT',
                                          'ENTREPRENEURSHIP',
                                          'ART',
                                          'LITERATURE',
                                          'LOCAL_EVENTS',
                                          'INVESTING',
                                          'STARTING_A_BUSINESS',
                                          'WOMEN_IN_TECH',
                                          'BAME_IN_TECH',
                                          'VETERANS_IN_TECH',
                                          'BANKING_AND_FINANCE',
                                          'MEDITATION_AND_SPIRITUALITY',
                                          'PHOTOGRAPHY'
);


CREATE TABLE interest_types (

    id SERIAL PRIMARY KEY,
    interests interests_career
);


CREATE TABLE interests_mapper (
    interests_id INTEGER ,
    user_id INTEGER ,
    FOREIGN KEY (interests_id) REFERENCES interest_types (id),
    FOREIGN KEY (user_id) REFERENCES users (id)
);


CREATE TYPE posts_type AS ENUM ('ADVERTISEMENT','EVENT','LIFESTYLE','FUNDRAISER','EVENT_PLAN');


CREATE TABLE post_types (
    id SERIAL PRIMARY KEY,
    post_type posts_type
);


ALTER TABLE posts ADD FOREIGN KEY (post_types_id) REFERENCES post_types (id);




