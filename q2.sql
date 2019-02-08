SELECT COUNT(*)
FROM member
WHERE member.id NOT IN(
    SELECT member.id
    FROM member,checkout_item
    WHERE member.id = checkout_item.member_id
);