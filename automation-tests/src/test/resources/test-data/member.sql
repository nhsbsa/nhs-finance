
delete from emp_auth_admin;
delete from pen_cont;
delete from emp_hist;
delete from member;
delete from emp_auth;
delete from address;

insert into address (
  address_id,
  line1,
  line2,
  line3,
  line4,
  line5,
  postcode
) values (
  1,
  '19 Larkholme Lane',
  'Fleetwood',
  'Lancashire',
   null,
   null,
  'FY7 8CD'
);

insert into address (
  address_id,
  line1,
  line2,
  line3,
  line4,
  line5,
  postcode
) values (
  2,
  '3 Foster Lane',
  'Blackpool',
  'Lancashire',
   null,
   null,
  'BL7 8BX'
);

insert into member(
    member_id,
    pension_number,
    username,
    title,
    first_name,
    middle_name,
    last_name,
    national_insurance_number,
    date_of_birth,
    date_of_birth_verified,
    uuid,
    gender,
    nominee_name,
    marital_status,
    email_address,
    mobile_number,
    telephone_number,
    preferred_contact_routes,
    receive_paperless_billing,
    home_add_id,
    postal_add_id)
values (
    1,
    '12345678',
    'sam.jones',
    1,
    'Sam',
    'Curtis',
    'Jones',
    'AA 12 34 56 D',
    '1981-07-15',
    true,
    '997bd0eb-cd6e-4829-a507-4d0218cf4e78',
    0,
    'James Smith',
    2,
    'sam.jones@email.com',
    '07414 371249',
    '01254 309564',
    0,
    true,
    1,
    2
);

insert into emp_auth (
    emp_auth_id,
    code,
    name,
    emp_add_id
) values (
    1,
    '456',
    'Berkshire Healthcare NHS Foundation Trust',
    1
);

insert into emp_auth_admin (
    emp_hist_auth_id,
    username,
    emp_auth_id
) values (
    123,
    '12345',
    1
);

insert into emp_hist (
    emp_hist_id,
    contribution_rate,
    employer_name,
    start_date,
    end_date,
    is_mental_health_officer,
    is_part_time,
    is_special_class,
    payroll_number,
    actual_hours,
    standard_hours,
    previously_known_as,
    emp_auth_id,
    member_id
) values (
    1,
    10,
    'Dave',
    '2010-01-01',
    '2012-02-02',
    false,
    false,
    false,
    '112233',
    37.5,
    40,
    'prev known as',
    1,
    1
);