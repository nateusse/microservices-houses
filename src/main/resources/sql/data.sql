INSERT IGNORE INTO categories (name, description) VALUES
    ('Luxury', 'House with premium finishes and exclusive areas'),
    ('Economical', 'Affordable house with standard size'),
    ('Pet-friendly', 'Designed to live with pets'),
    ('Smart Home', 'House with integrated smart technology'),
    ('Sustainable', 'Eco-friendly and energy-efficient construction'),
    ('Colonial Style', 'Traditional architectural design'),
    ('Minimalist', 'Functional design with clean lines'),
    ('Loft Apartment', 'Open space with no interior divisions'),
    ('Penthouse', 'Top floor with terrace and panoramic view'),
    ('Country House', 'Located in rural areas with large land'),
    ('Gated Community', 'Security and shared common areas'),
    ('Remodeled House', 'Recently renovated'),
    ('Duplex House', 'Two levels connected internally');


INSERT INTO departments (name, description) VALUES
                                                ('New York', 'Department of New York'),
                                                ('California', 'Department of California'),
                                                     ('Oregon', 'Department of Oregon'),
                                                ('Florida', 'Department of Florida'),
                                                ('Illinois', 'Department of Illinois'),
                                                ('Colorado', 'Department of Colorado'),
                                                ('Texas', 'Department of Texas'),
                                                ('Massachusetts', 'Department of Massachusetts'),
                                                ('Washington', 'Department of Washington');


INSERT INTO cities (name, description, id_department) VALUES
                                                          ('New York', 'City of New York', 1),
                                                          ('Los Angeles', 'City of Los Angeles', 2),
                                                          ('San Francisco', 'City of San Francisco', 2),
                                                          ('Portland', 'City of Portland', 3),
                                                          ('Miami', 'City of Miami', 4),
                                                          ('Chicago', 'City of Chicago', 5),
                                                          ('Denver', 'City of Denver', 6),
                                                          ('Austin', 'City of Austin', 7),
                                                          ('Cambridge', 'City of Cambridge', 8),
                                                          ('Seattle', 'City of Seattle', 9);


INSERT INTO locations (neighborhood, id_city) VALUES
                                                  ('Downtown Heights', 1),
                                                  ('Sunny Gardens', 2),
                                                  ('Tech Valley', 3),
                                                  ('Green Meadows', 4),
                                                  ('Ocean Breeze', 5),
                                                  ('Lakeside Retreat', 6),
                                                  ('Mountain View', 7),
                                                  ('Cultural Center', 8),
                                                  ('University Town', 9),
                                                  ('Business Hub', 10);
