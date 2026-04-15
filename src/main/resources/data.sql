-- Classes
INSERT INTO classes (id, class_name, description)
VALUES (2, 'Wizard', 'A scholarly magic-user who casts spells through study and intelligence.')
    ON CONFLICT DO NOTHING;

INSERT INTO classes (id, class_name, description)
VALUES (1, 'Cleric', 'A priestly champion who wields divine magic in service of a higher power.')
    ON CONFLICT DO NOTHING;

-- Spells
INSERT INTO spells (id, spell_name, level, casting_time, range, components, duration, concentration, description)
VALUES (1, 'Fireball', 3, 'ACTION', 150, 'V, S, M', 'Instantaneous', false, 'A bright streak flashes from your pointing finger to a point you choose.')
    ON CONFLICT DO NOTHING;

INSERT INTO spells (id, spell_name, level, casting_time, range, components, duration, concentration, description)
VALUES (2, 'Cure Wounds', 1, 'ACTION', 0, 'V, S', 'Instantaneous', false, 'A creature you touch regains hit points.')
    ON CONFLICT DO NOTHING;

-- Link spells to classes (class_spell join table)
INSERT INTO class_spell (class_id, spell_id) VALUES (2, 1) ON CONFLICT DO NOTHING;
INSERT INTO class_spell (class_id, spell_id) VALUES (1, 2) ON CONFLICT DO NOTHING;